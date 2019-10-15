package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ClassrmRepository classrmRepository;

    @RequestMapping("/")
    public String Home(Model model){
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("classrms", classrmRepository.findAll());
        return "index";
    }
    @RequestMapping("/studentlist")
    public String studentList(Model model){
        model.addAttribute("students", studentRepository.findAll());
        return "studentlist";
    }
    @GetMapping("/addstudent")
    public String studentForm(Model model){
        model.addAttribute("student", new Student());
        model.addAttribute("classrms", classrmRepository.findAll());
        return "studentform";
    }
    @PostMapping("/processstudent")
    public String processForm(@Valid Student student,
                              BindingResult result){
        if (result.hasErrors()){
            return "studentform";
        }
        studentRepository.save(student);
        return "redirect:/";

    }
    @RequestMapping("/classrmlist")
    public String classrmList(Model model){
        model.addAttribute("classrms", classrmRepository.findAll());
        return "classrmlist";
    }
    @GetMapping("/addclassrm")
    public String classrmForm(Model model){
        model.addAttribute("classrm", new Classrm());
//        model.addAttribute("students", studentRepository.findAll());
        return "classrmform";
    }
    @PostMapping("/processclassrm")
    public String processForm1(@Valid Classrm classrm,
                               BindingResult result){
        if (result.hasErrors()){
            return "classrmform";
        }
        classrmRepository.save(classrm);
        return "redirect:/classrmlist";

    }
    @RequestMapping("/detailstudent/{id}")
    public String showStudent(@PathVariable("id") long id, Model model)
    {model.addAttribute("student", studentRepository.findById(id).get());
        return "showstudent";
    }
    @RequestMapping("/updatestudent/{id}")
    public String updateStudent(@PathVariable("id") long id,Model model){
        model.addAttribute("student", studentRepository.findById(id).get());

        return "studentform";
    }
    @RequestMapping("/deletestudent/{id}")
    public String delStudent(@PathVariable("id") long id){
        studentRepository.deleteById(id);
        return "redirect:/";
    }
    @RequestMapping("/detailclassrm/{id}")
    public String showClassrm(@PathVariable("id") long id, Model model)
    {model.addAttribute("classrm", classrmRepository.findById(id).get());
        return "showclassrm";
    }
    @RequestMapping("/updateclassrm/{id}")
    public String updateClassrm(@PathVariable("id") long id,Model model){
        model.addAttribute("classrm", classrmRepository.findById(id).get());
        model.addAttribute("students", studentRepository.findAll());
        return "classrmform";
    }
    @RequestMapping("/deleteclassrm/{id}")
    public String delClassrm(@PathVariable("id") long id){
        classrmRepository.deleteById(id);
        return "redirect:/";
    }




}

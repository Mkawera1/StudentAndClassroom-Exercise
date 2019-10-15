package com.example.demo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private long id;
    private String name;
    private String studentNumber;
    private String major;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classrm_id")
    private Classrm classrm;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Classrm getClassrm() {
        return classrm;
    }

    public void setClassrm(Classrm classrm) {
        this.classrm = classrm;
    }
}

package com.example.admin_ops.bean;


import  javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="student")
public class Student implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roll;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer dom_id;

    @Column(nullable = false)
    private String qualification;

    public Student(Integer roll, String name, Integer dom_id, String qualification) {
        this.roll = roll;
        this.name = name;
        this.dom_id = dom_id;
        this.qualification = qualification;
    }

    public Student() {

    }

    public Integer getRoll() {
        return roll;
    }

    public void setRoll(Integer roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDom_id() {
        return dom_id;
    }

    public void setDom_id(Integer dom_id) {
        this.dom_id = dom_id;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

}

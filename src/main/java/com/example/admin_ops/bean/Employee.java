package com.example.admin_ops.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="employee")
public class Employee implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eid;

    @Column(nullable = false)
    private String pwd;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String name;


    public Employee(Integer eid, String pwd, String name, String type)
    {
        this.eid = eid;
        this.pwd = pwd;
        this.name = name;
        this.type = type;
    }

    public Employee() {

    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

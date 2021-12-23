package com.example.admin_ops.service;

import com.example.admin_ops.bean.Student;
import com.example.admin_ops.dao.implementation.StudentDao;
import com.example.admin_ops.dao.implementation.StudentDaoImpl;

import java.util.List;

public class StudentService
{
    StudentDao sd= new StudentDaoImpl();
    public List<Student> viewDetails(Student s)
    {
        return sd.viewDetails(s);
    }

    public boolean updateDetails(Student s) {
        return sd.updateDetails(s);
    }
}

package com.example.admin_ops.dao.implementation;

import com.example.admin_ops.bean.Student;

import java.util.List;

public interface StudentDao
{

    List<Student> viewDetails(Student s);

    boolean updateDetails(Student s);
}

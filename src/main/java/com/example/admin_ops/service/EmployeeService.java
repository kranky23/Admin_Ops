package com.example.admin_ops.service;

import com.example.admin_ops.bean.Employee;
import com.example.admin_ops.dao.implementation.EmployeeDao;
import com.example.admin_ops.dao.implementation.EmployeeDaoImpl;

public class EmployeeService
{
    EmployeeDao ed= new EmployeeDaoImpl();

    public Employee userIDVerify(Employee e)
    {
        return ed.userIDVerify(e);
    }

}

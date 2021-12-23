package com.example.admin_ops.dao.implementation;

import com.example.admin_ops.bean.Employee;
import com.example.admin_ops.bean.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import com.example.admin_ops.utils.SessionUtil;

public class EmployeeDaoImpl implements EmployeeDao
{
    @Override
    public Employee userIDVerify(Employee e)
    {
        try (Session session = SessionUtil.getSession())
        {
            Query query = session.createQuery("from Employee where eid=:eid and pwd=:pwd");
            query.setParameter("eid", e.getEid());
            query.setParameter("pwd",e.getPwd());
            System.out.println("Query list is " + query.list());
            for (final Object fetch : query.list())
            {
                Employee result =  (Employee) fetch;
                if(result.getType().equals("A"))
                    return (Employee) fetch;
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
        return null;
    }
}

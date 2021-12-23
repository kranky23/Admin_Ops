package com.example.admin_ops.dao.implementation;

import com.example.admin_ops.bean.Student;
import com.example.admin_ops.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao
{
    @Override
    public List<Student> viewDetails(Student s)
    {
        try (Session session = SessionUtil.getSession())
        {
            System.out.println(s.getDom_id() + "   Helloo  " );
            Query query = session.createQuery("from Student where dom_id = :dom_id");
            System.out.println("After query");
            query.setParameter("dom_id", s.getDom_id());
            System.out.println(query.list());
            List<Student> stu=new ArrayList<>();
            for (final Object fetch : query.list()) {
                stu.add((Student) fetch);
            }
            System.out.println("Array list is  " + stu);
            return stu;
        } catch (HibernateException exception) {
            exception.printStackTrace();
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
//        return null;
    }

    @Override
    public boolean updateDetails(Student s)
    {
        try (Session session = SessionUtil.getSession()) {
            Transaction tnx = null;
            tnx = session.beginTransaction();
            System.out.println("In Update Txn");
            Query query = session.createQuery("update Student set dom_id=:dom_id "+"where roll=:roll");
            System.out.println("Update query is " + query);
            query.setParameter("dom_id", s.getDom_id());
            int result = query.executeUpdate();
            tnx.commit();
            System.out.println("result is " + result);
            if(result>=1)
                return true;
            return false;
        } catch (HibernateException exception) {
            exception.printStackTrace();
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }
}

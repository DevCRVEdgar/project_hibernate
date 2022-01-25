package com.example.hibernate.repository;

import com.example.hibernate.core.HibernateUtil;
import com.example.hibernate.model.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EmployeeRepositoryimpl implements EmployeeRepository {

    @Override
    public int save(Employee employee) {
        Session session = null;
        Integer idsave = 0;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try{

        }catch(HibernateException e){
           e.printStackTrace();
        }

        return idsave;
    }
}

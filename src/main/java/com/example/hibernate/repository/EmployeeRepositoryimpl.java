package com.example.hibernate.repository;

import com.example.hibernate.core.HibernateUtil;
import com.example.hibernate.model.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeRepositoryimpl implements EmployeeRepository {

    @Override
    public Employee save(Employee employee) {
        Session session = null;
        Integer idsave = 0;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try{
            session = sessionFactory.openSession();

            Transaction transaction = session.beginTransaction();
            idsave = (Integer) session.save(employee);
            employee.setId(idsave);

            transaction.commit();

        }catch(HibernateException e){
           e.printStackTrace();
        }finally {
            if (session != null){
                session.close();
            }
        }

        return employee;
    }

    @Override
    public List<Employee> findAll() {
        Session session = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        List<Employee> employeeList = new ArrayList<>();

        try{
            session = sessionFactory.openSession();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Employee> criteriaQuery = builder.createQuery(Employee.class);

            criteriaQuery.from(Employee.class);

            employeeList = session.createQuery(criteriaQuery).getResultList();

        }catch (HibernateException e){
            e.printStackTrace();
        } finally {
            if (session != null){
                session.close();
            }
        }
        return employeeList;
    }

    @Override
    public List<Employee> findByName(String employeeName) {
        Session session = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        List<Employee> employeeList = new ArrayList<>();

        try{
            session = sessionFactory.openSession();


//            CriteriaBuilder builder = session.getCriteriaBuilder();

//            CriteriaQuery<Employee> criteriaQuery = builder.createQuery().where();
//            CriteriaQuery<Employee> criteriaQuery = builder.createQuery(Employee.class); //TODO - modificar para buscar por nome
//
//            criteriaQuery.from(Employee.class);
//
//            employeeList = session.createQuery(criteriaQuery).getResultList();

        }catch (HibernateException e){
            e.printStackTrace();
        } finally {
            if (session != null){
                session.close();
            }
        }
        return employeeList;
    }

    @Override
    public void deleteById(Integer id) {
        Session session = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Employee employeeDel = new Employee();
        employeeDel.setId(id);

        try{
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            session.delete(employeeDel);

            transaction.commit();

        }catch (HibernateException e){
            e.printStackTrace();
        } finally {
            if (session != null){
                session.close();
            }
        }

    }


}

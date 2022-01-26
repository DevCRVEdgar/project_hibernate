package com.example.hibernate;

import com.example.hibernate.controller.EmployeeController;
import com.example.hibernate.core.HibernateUtil;
import com.example.hibernate.model.Employee;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateApplication.class, args);
        Session session= HibernateUtil.getSessionFactory().openSession();

//        @Autowired
        EmployeeController controller =  new EmployeeController();

        Employee employee = new Employee();
        employee.setName("Edgar");
        employee.setSalary(500);

        session.beginTransaction();
        Employee employeeSave = controller.saveEmployee(employee);
        System.out.println("ID SALVO: " +  employeeSave);

//        String sql = "select version()";
//        String result = (String) session.createNativeQuery(sql).getSingleResult();
//
//        System.out.println(result);

        session.getTransaction().commit();
        session.close();
    }

}

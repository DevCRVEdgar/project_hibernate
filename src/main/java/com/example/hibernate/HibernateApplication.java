package com.example.hibernate;

import com.example.hibernate.core.HibernateUtil;
import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateApplication.class, args);
        Session session= HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        String sql = "select version()";
        String result = (String) session.createNativeQuery(sql).getSingleResult();

        System.out.println(result);

        session.getTransaction().commit();
        session.close();
    }

}

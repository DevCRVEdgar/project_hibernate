package com.example.hibernate.controller;

import com.example.hibernate.core.HibernateUtil;
import com.example.hibernate.model.Employee;
import com.example.hibernate.model.EmployeeContact;
import com.example.hibernate.repository.EmployeeRepository;
import com.example.hibernate.repository.EmployeeRepositoryimpl;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository = new EmployeeRepositoryimpl();
    Session session= HibernateUtil.getSessionFactory().openSession();


    @GetMapping
    public List<Employee> findAll() {
        return  employeeRepository.findAll();
    }

    @GetMapping("/testemployees")
    public List<Employee> createTest() {

        Employee e = new Employee();
        e.setName("Henry Walker");
        e.setSalary(30000);

        EmployeeContact ec1 = new EmployeeContact();
        ec1.setPhoneNumber(Long.valueOf(1111111));
        ec1.setType("HOME");

        EmployeeContact ec2 = new EmployeeContact();
        ec2.setPhoneNumber(Long.valueOf(22222));
        ec2.setType("WORK");

        Set<EmployeeContact> lc = new HashSet<>();
        lc.add(ec1);
        lc.add(ec2);
        e.setEmployeeContacts(lc);
        session.beginTransaction();
        employeeRepository.save(e);
        session.getTransaction().commit();

        session.beginTransaction();
        List<Employee> employeeList = employeeRepository.findAll();
        session.getTransaction().commit();

        return employeeList;
    }

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) {

        session.beginTransaction();
        Employee employeeSave = employeeRepository.save(employee);
        session.getTransaction().commit();

        return employeeSave;
    }

    @GetMapping("/{employeeName}")
    public List<Employee> findByName(@PathVariable("employeeName") String employeeName) {

        List<Employee> employeeList = employeeRepository.findByName(employeeName);

        return employeeList;
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        try {
            employeeRepository.deleteById(id);
            return "Deleted successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to delete";
        }
    }

}

package com.example.hibernate.repository;

import com.example.hibernate.model.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface EmployeeRepository {

    Employee save(Employee employee);
    List<Employee> findAll();
    List<Employee> findByName( String employeeName);
    void deleteById(Integer id);
}

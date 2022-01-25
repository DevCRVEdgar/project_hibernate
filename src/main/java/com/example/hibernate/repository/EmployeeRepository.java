package com.example.hibernate.repository;

import com.example.hibernate.model.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository {

    public int save(Employee employee);

}

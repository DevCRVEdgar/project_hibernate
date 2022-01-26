package com.example.hibernate.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "Employee")
@Table(name = "tbl_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_seq")
    @SequenceGenerator(initialValue = 1, name = "emp_seq", sequenceName = "employee_sequence",allocationSize = 1)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;



    @Column(name = "name")
    private String name;
    private Integer salary;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Set<EmployeeContact> employeeContacts;

    public Set<EmployeeContact> getEmployeeContacts() {
        return employeeContacts;
    }

    public void setEmployeeContacts(Set<EmployeeContact> employeeContacts) {
        this.employeeContacts = employeeContacts;
    }

    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public Employee setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getSalary() {
        return salary;
    }

    public Employee setSalary(Integer salary) {
        this.salary = salary;
        return this;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", employeeContacts=" + employeeContacts
                + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((employeeContacts == null) ? 0 : employeeContacts.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((salary == null) ? 0 : salary.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (employeeContacts == null) {
            if (other.employeeContacts != null)
                return false;
        } else if (!employeeContacts.equals(other.employeeContacts))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (salary == null) {
            if (other.salary != null)
                return false;
        } else if (!salary.equals(other.salary))
            return false;
        return true;
    }
}

package com.example.hibernate.model;

import javax.persistence.*;

@Entity
@Table(name = "employee_contact")
public class EmployeeContact {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empcontact_seq")
    @SequenceGenerator(initialValue = 1, name = "empcontact_seq", sequenceName = "employee_contact_sequence",allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "phone_number")
    private Long phoneNumber;
    private String type;


    @Column(name = "employee_id")
    private Long employeeId;


    public EmployeeContact() {
    }

    public Integer getId() {
        return id;
    }

    public EmployeeContact setId(Integer id) {
        this.id = id;
        return this;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNo) {
        this.phoneNumber = phoneNo;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "EmployeeContact [id=" + id + ", phoneNumber=" + phoneNumber + ", type=" + type + ", employeeId="
                + employeeId + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
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
        EmployeeContact other = (EmployeeContact) obj;
        if (employeeId == null) {
            if (other.employeeId != null)
                return false;
        } else if (!employeeId.equals(other.employeeId))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (phoneNumber == null) {
            if (other.phoneNumber != null)
                return false;
        } else if (!phoneNumber.equals(other.phoneNumber))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }
}

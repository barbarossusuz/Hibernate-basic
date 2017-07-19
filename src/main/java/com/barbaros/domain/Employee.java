package com.barbaros.domain;

/**
 * Created by barbaros on 19.7.2016.
 */

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "employee", catalog = "hibernatedb")
public class Employee {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "employee_id", unique = true, nullable = false)
    private Long employee_id;

    @Column(name = "employee_name", nullable = false, length = 45)
    private String employee_name;

    @Column(name = "employee_surname",  nullable = false, length = 45)
    private String employee_surname;

    @Column(name = "employee_salary",  nullable = false)
    private Long employee_salary;

    @ManyToOne
    @JoinColumn(name="department_id")//one to many
    private Department department;

    public Employee()
    {    }
    public Employee(String employee_name, String employee_surname, Long employee_salary) {
        this.employee_name = employee_name;
        this.employee_surname = employee_surname;
        this.employee_salary = employee_salary;
    }



   //get ve set


    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_surname() {
        return employee_surname;
    }

    public void setEmployee_surname(String employee_surname) {
        this.employee_surname = employee_surname;
    }

    public Long getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(Long employee_salary) {
        this.employee_salary = employee_salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}

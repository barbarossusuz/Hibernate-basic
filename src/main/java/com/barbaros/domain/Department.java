package com.barbaros.domain;


/**
 * Created by barbaros on 19.7.2016.
 */

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "department", catalog = "hibernatedb")
public class Department  {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "department_id", unique = true, nullable = false)
    private Long department_id;

    @Column(name = "department_name", nullable = false, length = 45)
    private String department_name;

    @Column(name = "department_desc", nullable = false, length = 45)
    private String department_desc;

    @OneToMany(mappedBy="department")//one to many
    private Set<Employee> employees;


    public Department()
    {    }

    public Department(String department_name, String department_desc) {
        this.department_desc = department_name;
        this.department_name = department_desc;
    }

    //bitiş


    @ManyToMany(cascade = {CascadeType.ALL})//many to many
    @JoinTable(name="department_meeting",catalog="hibernatedb",
            joinColumns={@JoinColumn(name="department_id", nullable = false, updatable = true)},
            inverseJoinColumns={@JoinColumn(name="meeting_id",nullable = false, updatable = true)})
    private Set<Meeting> meetings = new HashSet<Meeting>();

  //get -set

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Long getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Long department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getDepartment_desc() {
        return department_desc;
    }

    public void setDepartment_desc(String department_desc) {
        this.department_desc = department_desc;
    }

    public Set<Meeting> getMeetings() {
        return this.meetings;
    }

    public void setMeetings(Set<Meeting> meetings) {
        this.meetings = meetings;
    }
}

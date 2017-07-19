package com.barbaros.domain;


/**
 * Created by barbaros on 19.7.2016.
 */

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "meeting", catalog = "hibernatedb")
public class Meeting   {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "meeting_id", unique = true, nullable = false)
    private Long meeting_id;

    @Column(name = "meeting_name", nullable = false, length = 45)
    private String meeting_name;

    @Column(name = "meeting_desc", nullable = false, length = 45)
    private String meeting_desc;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy="meetings")
    private Set<Department> departments = new HashSet<Department>();

    public Meeting() {
    }

    public Meeting(String meeting_name, String meeting_desc) {
        this.meeting_name = meeting_name;
        this.meeting_desc = meeting_desc;
    }
    public Meeting(String meeting_name, String meeting_desc,Set<Department> departments) {
        this.meeting_name = meeting_name;
        this.meeting_desc = meeting_desc;
    }




    //get ve set


    public Long getMeeting_id() {
        return meeting_id;
    }

    public void setMeeting_id(Long meeting_id) {
        this.meeting_id = meeting_id;
    }

    public String getMeeting_name() {
        return meeting_name;
    }

    public void setMeeting_name(String meeting_name) {
        this.meeting_name = meeting_name;
    }

    public String getMeeting_desc() {
        return meeting_desc;
    }

    public void setMeeting_desc(String meeting_desc) {
        this.meeting_desc = meeting_desc;
    }

    public Set<Department> getDepartments() {
        return this.departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }
}


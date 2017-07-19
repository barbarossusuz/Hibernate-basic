package com.barbaros;

import com.barbaros.domain.Department;
import com.barbaros.domain.Employee;
import com.barbaros.domain.Meeting;
import com.barbaros.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by barbaros on 19.7.2016.
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Deneme!" );
        //session
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        //dep
        Department department = new Department();
        department.setDepartment_name("mebitech");
        department.setDepartment_desc("yazılım");
        session.save(department);

        //emp
        Employee emp1 = new Employee("barbaros","susuz",(long)1000);
        Employee emp2 = new Employee("barbaros2","susuz2",(long)2000);
        //join
        emp1.setDepartment(department);
        emp2.setDepartment(department);
        session.save(emp1);
        session.save(emp2);

        //meet
        Meeting meeting = new Meeting();
        meeting.setMeeting_name("x yazılımı");
        meeting.setMeeting_desc("brainstorming");
        //join
        Set<Meeting> meetings = new HashSet<Meeting>();
        meetings.add(meeting);

        department.setMeetings( meetings);
        session.save(meeting);


        session.getTransaction().commit();
        session.close();
        System.out.println("done");

    }
}

package MainApp;

import domain.Course;
import domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApp2 {
    public static void main(String[] args) {
        //DECLARE THE RESOURCES
        Configuration cfg=null;
        Session ses=null;
        SessionFactory factory=null;
        Transaction tx=null;

        //CREATE THE OBJECT
        cfg=new Configuration();
        cfg=cfg.configure();
        cfg.addAnnotatedClass(Student.class);
        cfg.addAnnotatedClass(Course.class);
        factory= cfg.buildSessionFactory();
        ses=factory.openSession();

        Student s1=new Student();
        s1.setStudName("Priya");
        Student s2=new Student();
        s2.setStudName("Anushka");
        Course c1=new Course();
        c1.setCourseName("HTML");

        //ADD COURSE OBJECTS INTO COURSELIST
        s1.addCourses(c1);

        tx= ses.beginTransaction();
        ses.save(s1);
        ses.save(s2);
        ses.save(c1);
        tx.commit();
        System.out.println("data inserted  Successfully");
    }
    }


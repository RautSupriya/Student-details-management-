package MainApp;

import domain.Course;
import domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApp1 {
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
        s1.setStudName("Supriya");
        Course c1=new Course();
        c1.setCourseName("Java");
        Course c2=new Course();
        c2.setCourseName("J2EE");

        //ADD COURSE OBJECTS INTO COURSELIST
        s1.addCourses(c1);
        s1.addCourses(c2);

        tx= ses.beginTransaction();
        ses.save(s1);
        ses.save(c1);
        ses.save(c2);
        tx.commit();
        System.out.println("data inserted  Successfully");
    }
}

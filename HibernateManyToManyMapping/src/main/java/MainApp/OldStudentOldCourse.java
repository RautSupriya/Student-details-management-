package MainApp;

import domain.Course;
import domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class OldStudentOldCourse {
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

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Course id: ");
        int course_id= sc.nextInt();
        Course c1=ses.get(Course.class,course_id);
        System.out.println("Enter the student id:");
        int student_id= sc.nextInt();
        Student s1=ses.get(Student.class,student_id);
        c1.addStudent(s1);
        s1.addCourses(c1);

        tx= ses.beginTransaction();
        ses.save(s1);
        ses.save(c1);
        tx.commit();
        System.out.println("Old Student Old Course are inserted");
    }

}

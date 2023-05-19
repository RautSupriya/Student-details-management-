package MainApp;

import domain.Course;
import domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class MainApp7 {
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
        System.out.println("Enter course id: ");
        int course_id= sc.nextInt();
        Course c1=ses.get(Course.class,course_id);
        tx= ses.beginTransaction();
        ses.delete(c1);
        tx.commit();
        System.out.println("=====================================");
        System.out.println("COURSE DELETED SUCCESSFULLY");
    }
}

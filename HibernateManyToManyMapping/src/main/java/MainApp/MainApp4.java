package MainApp;

import domain.Course;
import domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

//DISPLAY COURSE SELECTED BY PERTICULAR
public class MainApp4 {
    public static void main(String[] args) {
        //DECLARE THE RESOURCES
        Configuration cfg = null;
        Session ses = null;
        SessionFactory factory = null;
        Transaction tx = null;

        //CREATE THE OBJECT
        cfg = new Configuration();
        cfg = cfg.configure();
        cfg.addAnnotatedClass(Student.class);
        cfg.addAnnotatedClass(Course.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter student id: ");
        int stud_id=sc.nextInt();
        Student s1=ses.get(Student.class,stud_id);
        List<Course>courseList=s1.getCourseList();
        System.out.println("Select course: ");
        for (Course c1:courseList){
            System.out.println(c1.getCourseName());
        }
    }
}
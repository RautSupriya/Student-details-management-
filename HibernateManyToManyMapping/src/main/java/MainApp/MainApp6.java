package MainApp;

import domain.Course;
import domain.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MainApp6 {
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

        Criteria crt= ses.createCriteria(Course.class);
        List<Course>courseList=crt.list();
        for (Course c:courseList){
            System.out.println("Course name: "+c.getCourseName());
            List<Student>studentList=c.getStudentList();
            for (Student s:studentList){
                System.out.println(s.getStudName());
            }
            System.out.println("============================");
        }
    }
}
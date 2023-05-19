package MainApp;

import domain.Course;
import domain.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MainApp5 {
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

        Criteria crt=ses.createCriteria(Student.class);
        List<Student>studentList=crt.list();
        for (Student s1:studentList){
            System.out.println(s1.getStudId()+" : "+s1.getStudName());
            System.out.println("--------------------------------");
            List<Course>courseList=s1.getCourseList();
            System.out.println("Course name: ");
            for (Course c1:courseList)
            {

                System.out.println(c1.getCourseName());
            }
        }
    }
}

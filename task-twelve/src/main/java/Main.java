
import com.practice.orm.models.Course;
import com.practice.orm.models.Student;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String [] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate-config.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Student> students = new ArrayList<>();
        List<Course> courses = new ArrayList<>();

        Collections.addAll(students,
                new Student("Mahmoud"));

        Collections.addAll(courses,
                new Course("Spring Bootcamp"),
                new Course("Keycloak Mastery"));

        for(Course course:courses){
            session.persist(course);
        }

        for (Student student : students){
            student.setCourses(courses);
            session.persist(student);
        }

        Query query = session.createQuery("from Student");

        System.out.println(query.getSingleResult().toString());




        session.getTransaction().commit();
    }
}

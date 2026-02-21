import com.practice.orm.models.Answer;
import com.practice.orm.models.Course;
import com.practice.orm.models.Instructor;
import com.practice.orm.models.Question;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {
    public static void main(String [] args){

        SessionFactory sessionFactory = new Configuration().configure("hibernate-config.xml")
                .addAnnotatedClass(Question.class)
                .addAnnotatedClass(Answer.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        Question question = new Question();
        question.setQuestionName("What's Your Name?");

        List<Answer> answers = new ArrayList<>();

        Collections.addAll(answers,
                new Answer("My Name is Michael"),
                new Answer("My Name is Mahmoud"));

        question.setAnswers(answers);
        session.persist(question);
        session.flush();

        Query query = session.createQuery("from Question");
        System.out.println(query.getSingleResult().toString());


        Instructor instructor = new Instructor("Mahmoud");

        List<Course> courses = new ArrayList<>();

        Collections.addAll(courses,
                new Course("CS61B"),
                new Course("CS61A"));
        instructor.setCourses(courses);
        session.persist(instructor);
        session.flush();

        query = session.createQuery("from Instructor");

        System.out.println(query.getSingleResult());


        session.getTransaction().commit();

    }
}

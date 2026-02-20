package com.practice.hibernate;

import com.practice.hibernate.models.Passport;
import com.practice.hibernate.models.Person;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args){
        SessionFactory sessionFactory = new Configuration().configure("hibernate-config.xml")
                .addAnnotatedClass(Passport.class)
                .addAnnotatedClass(Person.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Person person = new Person();
        person.setFirstName("Mahmoud");
        person.setLastName("Essam");
        person.setBirthDate(LocalDate.of(1996,6,23));

        session.persist(person);
        session.flush();

        Passport passport = new Passport();
        passport.setPassportNo("A23F56");
        passport.setExpiryDate(LocalDate.of(2028,8,19));
        passport.setPerson(person);

        person.setPassport(passport);
        session.persist(passport);
        session.persist(person);
        session.flush();




        Query query = session.createQuery("from Person");

        List<Person> personList = query.getResultList();
        System.out.println(personList);

        query = session.createQuery("from Passport");
        List<Passport> passportList = query.getResultList();

        System.out.println(passportList);

//        query = session.createQuery("update Passport set person_id=:p where id=1");
//        query.setParameter("p",1);
//        int status = query.executeUpdate();
//        System.out.println(status);
//
//        query = session.createQuery("from Person");
//        personList = query.getResultList();
//        System.out.println(personList.get(0));
//
//        query = session.createQuery("from Passport");
//         passportList = query.getResultList();
//        System.out.println(passportList.get(0));





        session.getTransaction().commit();

    }
}

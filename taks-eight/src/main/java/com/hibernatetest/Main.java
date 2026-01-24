package com.hibernatetest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

public class Main {
    public static void main(String[] args){

        SessionFactory sessionFactory = new Configuration().configure("hibernate-config.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        User user = new User(7,"Mahmoud","Essam","mensheteh@gmail.com", LocalDate.now(),"Egypt");
//        session.beginTransaction();
//        session.save(user);
//        session.getTransaction().commit();

//        session.beginTransaction();
//
//        user = session.get(User.class,7);
//        System.out.println(user);
//
//        session.getTransaction().commit();

//        session.beginTransaction();
//        user = session.get(User.class,7);
//        System.out.println(user);
//        user.setCity("Sengal");
//        System.out.println(user);
//        session.getTransaction().commit();

        session.beginTransaction();
        user = session.get(User.class,7);

        session.delete(user);

        session.getTransaction().commit();





    }
}

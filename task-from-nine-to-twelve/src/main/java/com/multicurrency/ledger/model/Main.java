package com.multicurrency.ledger.model;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args){
        SessionFactory sessionFactory = new Configuration().configure("hibernate-config.xml")
                .addAnnotatedClass(Traders.class)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();
        for (int i = 0; i < 100; i++) {
            Traders t = new Traders();
            t.setEmail("trader_" + i + "@titanx.fin");
            t.setName("Institutional Client " + i);
            t.setBalance(BigDecimal.ZERO);

            session.persist(t);
            if (i > 0 && i % 50 == 0) {
                session.flush();
                session.clear();
            }
        }


        Query query = session.createQuery("from Traders");
        List<Traders> traders = query.getResultList();

        System.out.println(traders);

        query = session.createQuery("update Traders set email=:e where id=:i");
        query.setParameter("e","mmensheteh@gmail.com");
        query.setParameter("i",1);
        int status = query.executeUpdate();
        System.out.println(status);


        query = session.createQuery("from Traders");
        query.setFirstResult(5);
        query.setMaxResults(10);
        List list = query.getResultList();
        System.out.println(list);

//        User user  = new User();
//        user.setName("Mahmoud");
//        user.setPassword("12345");
//        user.setTodayDate(LocalDate.now().toString());
//        user.setCreationDate(LocalDate.now());
//        session.persist(user);
//        session.flush();

        query = session.createQuery("from User");

        List<User> list1 = query.getResultList();

        System.out.println(list1);









        session.getTransaction().commit();
    }
}

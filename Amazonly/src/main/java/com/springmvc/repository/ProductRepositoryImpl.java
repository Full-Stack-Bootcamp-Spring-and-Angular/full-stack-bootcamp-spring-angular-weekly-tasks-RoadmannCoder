package com.springmvc.repository;

import com.springmvc.models.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Product findById(int id) {
        try{
            Session session = sessionFactory.getCurrentSession();
            return (Product) session.get(Product.class, id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void add(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(product);
    }

    @Override
    public void deleteById(int id) {
        try{
            Session session = sessionFactory.getCurrentSession();
            Product product = (Product) session.get(Product.class,id);
            session.delete(product);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.update(product);

    }

    @Override
    public List<Product> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query =  session.createQuery("from Product");
        List products = query.list();
        return products;
    }
}

package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibenate.entity.User;

public class PrefixExample {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        
        Session session = factory.openSession(); 

        try {
            
            session.beginTransaction();

            
           String prefix = "Y%"; 
           String hql = "FROM User WHERE name LIKE:prefix";
            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("prefix", prefix);

            
            User user = query.uniqueResult();

            if (user != null) {
                System.out.println("User found with prefix " +prefix.charAt(0)  + ":");
                System.out.println(user);
            } else {
                System.out.println("No user found with email " +prefix.charAt(0)  + ":" );
            }

            
            session.getTransaction().commit();

        } finally {
            session.close(); 
            factory.close();
        }
    }

	}


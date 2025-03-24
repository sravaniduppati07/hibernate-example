package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibenate.entity.User;

public class CreateUserDemo {
    public static void main(String[] args) {
        // Create a SessionFactory
    	
    	
    	
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();

        // Create a Session
        Session session = sessionFactory.openSession();

        try {
            // Create a new User object
            User user = new User();
            user.setName("John");
            user.setEmail("john.doe@example.com");
            
            User user1 = new User();            
            user1.setName("Sravani");
            user1.setEmail("sravani.d@example.com");
            
            User user2= new User();            
            user2.setName("Priya");
            user2.setEmail("nandini.d@example.com");
            
            User user3 = new User();            
            user3.setName("Anusha");
            user3.setEmail("anusha.e@example.com");
            

            // Begin a transaction
            session.beginTransaction();

            // Save the user to the database
            session.save(user);
            session.save(user1);
            session.save(user2);
            session.save(user3);
           // session.update(user);

            // Commit the transaction
            session.getTransaction().commit();

            System.out.println("User saved successfully!");
        } finally {
            // Close the session
            session.close();
            sessionFactory.close();
        }
        
    }
}
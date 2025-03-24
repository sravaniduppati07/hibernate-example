package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibenate.entity.User;

import org.hibernate.Transaction;

public class UpdateUserDemo {
    public static void main(String[] args) throws Exception {
        // Create a SessionFactory
    	
    	int userId = 1;
    	
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();

        // Create a Session
        Session session = sessionFactory.openSession();
        Transaction transaction=null;

        try {
            // Create a new User object
        	 // Retrieve the user by ID
        
            User user = session.get(User.class, userId);

            if (user != null) {
                // Update the user's details
                user.setName("Mukundha");
                user.setEmail("Mukundha@gmail.com");

            // Begin a transaction
                transaction= session.beginTransaction();

            // Save the user to the database
            session.merge(user);
           // session.update(user);
            

            // Commit the transaction
            transaction.commit();

            System.out.println("User updated successfully!");
        } 
            else{
            	
            	System.out.println("User Not Found for this userId"+userId);
            	
            }
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
            finally {
            // Close the session
            session.close();
            sessionFactory.close();
        }
    }
        
    
}
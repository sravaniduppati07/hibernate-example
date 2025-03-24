package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibenate.entity.User;

import org.hibernate.Transaction;

public class DeleteUserDemo {
    public static void main(String[] args) throws Exception {
        // Delete a SessionFactory
    	
    	int userId=4;
    	
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();

        // Delete a Session
        Session session = sessionFactory.openSession();
        Transaction transaction=null;

        try {
            
        	// Begin a transaction
            transaction= session.beginTransaction();               

        
            User user = session.get(User.class, userId);

            if (user != null) {
            	
            	session.delete(user);
              
            // Commit the transaction
            transaction.commit();

            System.out.println("User deleted successfully!");
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
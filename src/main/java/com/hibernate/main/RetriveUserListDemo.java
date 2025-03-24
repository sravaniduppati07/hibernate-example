package com.hibernate.main;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibenate.entity.User;

import jakarta.persistence.Query;

public class RetriveUserListDemo {
    public static void main(String[] args) {
        // Create a SessionFactory
    	
    	retrieveAllUsers();
    }

    private static void retrieveAllUsers() {
        // Create a SessionFactory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        // Open a session
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction(); // Begin transaction
            
            Query query = session.createQuery("FROM User", User.class);
            List<User> users = query.getResultList();
            
            if (users.isEmpty()) {
                System.out.println("No users found.");
            } else {
                for (User user : users) {
                    System.out.println("ID: " + user.getId() +
                                       ", Name: " + user.getName() +
                                       ", Email: " + user.getEmail());
                }
            }

            transaction.commit(); // Commit transaction
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	
            sessionFactory.close(); // Close SessionFactory
            
        }
    }
    	
}
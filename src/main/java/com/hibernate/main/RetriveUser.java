package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;

import com.hibenate.entity.User;

public class RetriveUser {
	
		    public static void main(String[] args) {
		        // Create a SessionFactory
		        SessionFactory factory = new Configuration()
		                .configure("hibernate.cfg.xml")
		                .addAnnotatedClass(User.class)
		                .buildSessionFactory();

		        // Create a Session
		        Session session = factory.openSession(); // Use openSession() instead of getCurrentSession()

		        try {
		            // Start a transaction
		            session.beginTransaction();

		            // HQL Query to get user by email
		           String emailToFind = "example@example.com"; // Replace with the email you want to search for
		          String hql = "FROM User WHERE email = :email";
		            Query<User> query = session.createQuery(hql, User.class);
		            query.setParameter("email", emailToFind);

		            // Execute the query and get the result
		            User user = query.uniqueResult();

		            if (user != null) {
		                System.out.println("User found with email " + emailToFind + ":");
		                System.out.println(user);
		            } else {
		                System.out.println("No user found with email " + emailToFind);
		            }

		            // Commit transaction
		            session.getTransaction().commit();

		        } finally {
		            session.close(); // Manually close the session
		            factory.close();
		        }
		    }

}

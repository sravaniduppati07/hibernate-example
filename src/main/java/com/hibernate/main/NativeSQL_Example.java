package com.hibernate.main;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.hibernate.query.Query;

import com.hibenate.entity.User;

public class NativeSQL_Example {

	

	public static void main(String[] args) {
      SessionFactory factory= new Configuration().configure("Hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();
      
      Session session= factory.openSession();
      
      
      try {
    	  session.beginTransaction();
    	  String prefix= "Y%";
    	  String SQL = "Select * from Users where name like :prefix";
    	  Query<User> query = session.createNativeQuery(SQL, User.class);
          query.setParameter("prefix", prefix);
    	
          List<User>users=query.getResultList();
          
          if (!users.isEmpty()) {
              System.out.println("Users whose names start with '" + prefix.charAt(0) + "':");
              for (User user : users) {
                  System.out.println(user);
              }
          } 
          else 
          {
              System.out.println("No users found whose names start with '" + prefix.charAt(0) + "'");
    	  
      }
          session.getTransaction().commit();
	}
      finally {
    	  session.close();
      }
    	 
      }

	
}

package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibenate.entity.department;
import com.hibenate.entity.employee;

public class HibernateTransactionmanagementExample {

	public static void main(String[] args) {
SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(employee.class).addAnnotatedClass(department.class).buildSessionFactory();
        
        // Open a session
        Session session = factory.openSession();
        
        Transaction transaction = null;
     
        try {
            transaction = session.beginTransaction();
         
            department dept = session.get(department.class, 112);
            if (dept== null) {
                System.out.println("Error: Department not found!");
                return;
            }
            employee emp = new employee("Priyanka", 99000.00,"Priyanka@gmail.com", dept);

            // 🔍 Debugging: Check if empName is set
            System.out.println("Saving Employee: " + emp.getEmpName()); 

            session.save(emp);
            transaction.commit();
         

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); 
                System.out.println("Transaction rolled back due to an error.");
            }
            e.printStackTrace();
        } finally {
            session.close(); // Close session
            factory.close(); // Close factory
        }
    }
	}


package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibenate.entity.department;
import com.hibenate.entity.employee;
import jakarta.*;
/*public class BidirectionalExample {

	public static void main(String[] args) {
	
	SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(department.class)
                .addAnnotatedClass(employee.class)
                .buildSessionFactory();

        // Create a Session
        Session session = factory.getCurrentSession();
		        // Create a SessionFactory
		        

		        try {
		        	
		            // Start a transaction
		            session.beginTransaction();

		         // Create a Department
		            department department = new department("IT");

		            // Create Employees
		            employee emp1 = new employee("Priyanka", 99000.0);
		            employee emp2 = new employee("nandini", 45000.0);

		            // Add Employees to the Department
		            department.addEmployee(emp1);
		            department.addEmployee(emp2);

		            // Save the Department (Cascade will save the Employees)
		            session.save(department);

		            // Commit transaction
		            session.getTransaction().commit();

		            // Retrieve and print the Department and Employees
		            session = factory.getCurrentSession();
		            session.beginTransaction();

		            department savedDepartment = session.get(department.class, department.getDeptID(129));
		            System.out.println("Department: " + savedDepartment);
		            System.out.println("Employees: " + savedDepartment.getEmployees(emp1));

		            session.getTransaction().commit();
		            session.close();

		        } finally {
		            factory.close();
		            
		           
		        }
		    }
	
	}
}*/


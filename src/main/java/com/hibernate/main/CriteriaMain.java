package com.hibernate.main;
import java.util.List;
import jakarta.persistence.criteria.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibenate.entity.department;
import com.hibenate.entity.employee;


/*public class CriteriaMain {
	

		            public static void main(String[] args) {
		                

		            SessionFactory factory = new Configuration()
		                    .configure("hibernate.cfg.xml")
		                    .addAnnotatedClass(employee.class)
		                    .addAnnotatedClass(department.class)// Fixed class name
		                    .buildSessionFactory();

		            // ✅ Open session
		            Session session = factory.openSession();
		            Transaction transaction = null; // Declare transaction

		            try {
		                transaction = session.beginTransaction();

		                // ✅ Use CriteriaBuilder (Modern Approach)
		                CriteriaBuilder cb = session.getCriteriaBuilder();
		                CriteriaQuery<employee> cq = cb.createQuery(employee.class);
		                Root<employee> root = cq.from(employee.class);

		                // ✅ Use the correct field name (Java field, not DB column name)
		                cq.select(root).where(cb.greaterThan(root.get("empSalary"), 50000));

		                // Execute query
		                List<employee> employees = session.createQuery(cq).getResultList();

		                // Print Results
		                for (employee emp : employees) {
		                    System.out.println("Employee Name: " + emp.getEmpName() + ", Salary: " + emp.getSalary());
		                }

		                transaction.commit();
		            } catch (Exception e) {
		                if (transaction != null) transaction.rollback(); // Handle rollback properly
		                e.printStackTrace();
		            } finally {
		                session.close();
		                factory.close();
		            }
		        }

		        
	}*/
	
    


    



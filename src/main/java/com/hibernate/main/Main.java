package com.hibernate.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibenate.entity.department;
import com.hibenate.entity.employee;

public class Main {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(employee.class)
				.addAnnotatedClass(department.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			

			String sql = "SELECT d.DeptName AS department_name, " + "COUNT(e.EmpID) AS total_employees, "
					+ "AVG(e.EmpSalary) AS average_salary, " + "MAX(e.EmpSalary) AS max_salary, "
					+ "(SELECT e2.EmpName " + " FROM employee e2 " + " WHERE e2.DeptID = d.DeptID "
					+ " ORDER BY e2.EmpSalary DESC " + " LIMIT 1) AS highest_paid_employee " + "FROM department d "
					+ "JOIN employee e ON d.DeptID = e.DeptID " + "GROUP BY d.DeptName, d.DeptID "
					+ "HAVING COUNT(e.EmpID) < 13";
			
			System.out.println("Executing SQL Query: " + sql);

			Query query = session.createNativeQuery(sql);
			List<Object[]> results = query.getResultList();
			
			 System.out.println("Number of results: " + results.size());

			System.out
					.println("Department Name | Total Employees | Average Salary | Max Salary | Highest Paid Employee");
			System.out.println(
					"----------------------------------------------------------------------------------------");
			
			
				for (Object[] row : results) {
				    String DeptName = (String) row[0];
				    Long total_employees = (Long) row[1];
				    Double average_salary = (Double) row[2];
				    Double max_salary = (Double) row[3];
				    String highest_paid_employee = (String) row[4];

System.out.printf( "%-20s | %-15d | %-15.2f | %-15.2f | %-20s%n",DeptName ,total_employees, average_salary,  max_salary, highest_paid_employee);
				    

			}

			// Commit transaction
			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}

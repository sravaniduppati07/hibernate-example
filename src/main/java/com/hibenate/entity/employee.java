package com.hibenate.entity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

	

	@Entity
	@Table(name = "employee") // ✅ Make sure this matches the actual database table name
	public class employee {

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    @Column(name = "EmpName", nullable = false) // Prevents null values
	    private String empName;

	    @Column(name = "EmpSalary")
	    private double salary;

	    @ManyToOne
	    @JoinColumn(name = "DeptID") // Foreign Key
	    private department department;

	    // ✅ Default constructor (Required by Hibernate)
	    public employee(String string, double d, String string2, com.hibenate.entity.department dept) { }

	    // ✅ Parameterized constructor (Ensure empName is assigned correctly)
	    public employee(String empName, double salary, department department) {
	        this.empName = empName; // 🔥 Make sure this is properly assigned
	        this.salary = salary;
	        this.department = department;
	    }

	    // Getters and Setters
	    public String getEmpName() { return empName; }
	    public void setEmpName(String empName) { this.empName = empName; }

		public String getEmpName(String string) {
			// TODO Auto-generated method stub
			return null;
		}

		public String getSalary() {
			// TODO Auto-generated method stub
			return null;
		}
	}

		


package com.hibenate.entity;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

	@Entity
	@Table(name = "department")
	public class department {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int DeptID;

	    @Column(name = "DeptName")
	    private String DeptName;
	    

	    public department(int deptID, String deptName, List<employee> employees) {
			super();
			DeptID = deptID;
			DeptName = deptName;
			this.employees = employees;
		}

	    public department() {}

	    // Parameterized constructor (optional)
	    public department(String name) {
	        this.DeptName = name;

	    }
		public int getDeptID(int i) {
			return DeptID;
		}

		public void setDeptID(int deptID) {
			DeptID = deptID;
		}

		public String getDeptName() {
			return DeptName;
		}

		public void setDeptName(String deptName) {
			DeptName = deptName;
		}

		public List<employee> getEmployees() {
			return employees;
		}

		public void setEmployees(List<employee> employees) {
			this.employees = employees;
		}

		@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	    private List<employee> employees= new ArrayList<>();
	    
	    @Override
	    public String toString() {
	        return "department{" +
	                "deptId=" + DeptID +
	                ", deptName='" + DeptName + '\'' +
	                '}';
	    }

		public void addEmployee(employee emp1) {
			// TODO Auto-generated method stub
			
		}

		public Object getDeptID1(int i) {
			// TODO Auto-generated method stub
			return null;
		}

		public String getEmployees(employee emp1) {
			// TODO Auto-generated method stub
			return null;
		}

	    
}

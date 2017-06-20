package pojo;

import javax.persistence.*;

@Entity
@Table(name="employee")
public class EmployeePOJO {
	int empID;
	String empName, empCity;
	double empSalary;
	DepartmentPOJO department;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="eID")
	public int getEmpID() {
		return empID;
	}
	
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	@Column(columnDefinition="double(10,2)")
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	
	public String getEmpCity() {
		return empCity;
	}
	public void setEmpCity(String empCity) {
		this.empCity = empCity;
	}
	
	@ManyToOne
	@JoinColumn(name = "deptid")//name can be anything.
	public DepartmentPOJO getDepartment() {
		return department;
	}
	
	public void setDepartment(DepartmentPOJO department) {
		this.department = department;
	}
	
	public EmployeePOJO() {
	}
	
	public EmployeePOJO(String empName, String empCity, double empSalary) {
		this.empName = empName;
		this.empCity = empCity;
		this.empSalary = empSalary;
	}

	@Override
	public String toString() {
		return "EmployeePOJO [empID=" + empID + ", empName=" + empName + ", empCity=" + empCity + ", empSalary="
				+ empSalary + "]";
	}
	
	
}
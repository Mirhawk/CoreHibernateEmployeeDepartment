package dao;

public class EmployeeDAO {
	int empID;
	String empName, empCity;
	double empSalary;
	
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
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	public EmployeeDAO(String empName, String empCity, double empSalary) {
		this.empName = empName;
		this.empCity = empCity;
		this.empSalary = empSalary;
	}
	
	public EmployeeDAO() {}
	
}
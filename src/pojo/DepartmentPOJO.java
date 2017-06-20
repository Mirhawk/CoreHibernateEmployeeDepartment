package pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Department")
public class DepartmentPOJO {
	int deptID;
	String deptName;
	List <EmployeePOJO> emplList = new ArrayList<>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getDeptID() {
		return deptID;
	}
	
	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}
	
	public String getDeptName() {
		return deptName;
	}
	
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	@OneToMany(mappedBy="department", cascade= CascadeType.ALL)
	public List<EmployeePOJO> getEmplList() {
		return emplList;
	}

	public void setEmplList(List<EmployeePOJO> emplList) {
		this.emplList = emplList;
	}
	
	public void addEmployee(EmployeePOJO emp) {
		emplList.add(emp);
		emp.setDepartment(this);
	}
	
	public void removeEmployee(EmployeePOJO emp) {
		emp.setDepartment(null);
		emplList.remove(emp);
	}
	
	public DepartmentPOJO(String deptName) {
		this.deptName = deptName;
	}
	
	public DepartmentPOJO() {}

	@Override
	public String toString() {
		return "DepartmentPOJO [deptID=" + deptID + ", deptName=" + deptName + ", emplList=" + emplList + "]";
	}
	
}

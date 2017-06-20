package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojo.DepartmentPOJO;
import pojo.EmployeePOJO;

import static utils.HibernateUtils.*;

public class DepartmentDAO {
	int deptID;
	String deptName;
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

	
	public void addDepartment(DepartmentPOJO department) {
		Session session = getSf().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(department);
			transaction.commit();
		}
		catch(HibernateException he) {
			if(transaction != null)
				transaction.rollback();
		}
		finally {
			session.close();
			
		}
	}
	
	public DepartmentPOJO getDepartment(int deptID) {
		Session session = getSf().openSession();
		Transaction transaction = session.beginTransaction();
		DepartmentPOJO department = null;
		try {
			department = session.get(DepartmentPOJO.class,deptID);
			transaction.commit();
		}
		catch(HibernateException he) {
			if(transaction != null)
				transaction.rollback();
		}
		finally {
			session.close();
		}
		return department;
	}
	
	public void hireEmployee(DepartmentPOJO department) {
		Session session = getSf().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(department);
			transaction.commit();
		}
		catch(HibernateException he) {
			if(transaction != null)
				transaction.rollback();
		}
		finally {
			session.close();
		}
	}
	
	public void hireEmployee2(int deptID, EmployeePOJO emp) {
		Session session = getSf().openSession();
		Transaction transaction = session.beginTransaction();
		DepartmentPOJO department = null;
		try {
			department = session.get(DepartmentPOJO.class,deptID);
			department.addEmployee(emp);
			session.update(department);
			transaction.commit();
		}
		catch(HibernateException he) {
			if(transaction != null)
				transaction.rollback();
		}
		finally {
			session.close();
		}
	}
}

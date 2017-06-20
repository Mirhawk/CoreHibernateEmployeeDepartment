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
		
		if(department != null)
		{
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
		else {
			//department object sent is null
		}
	}
	
	public DepartmentPOJO getDepartment(int deptID) {
		Session session = getSf().openSession();
		Transaction transaction = session.beginTransaction();
		String getDeptHQL = "SELECT dept FROM DepartmentPOJO dept WHERE dept.deptID = :deptid";
		DepartmentPOJO department = null;
		try {
//			department = session.createQuery(getDeptHQL, DepartmentPOJO.class).setParameter("deptid", deptID).getSingleResult();
			department = session.get(DepartmentPOJO.class,deptID);
			department.getEmplList().size();
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
		if(department != null) {
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
	}
	
	public void hireEmployee2(int deptID, EmployeePOJO emp) {
		Session session = getSf().openSession();
		Transaction transaction = session.beginTransaction();
		DepartmentPOJO department = null;
		try {
			department = session.get(DepartmentPOJO.class,deptID);
			if(department != null) {
				department.addEmployee(emp);
				session.update(department);
			}
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
	
	public void fireEmployee(int empID) {
		Session session = getSf().openSession();
		Transaction transaction = session.beginTransaction();
		EmployeePOJO employee = null;
		DepartmentPOJO department = null;
		try {
//			department.
			employee = session.get(EmployeePOJO.class,empID);
			if(employee != null) {
				department = session.get(DepartmentPOJO.class, employee.getDepartment().getDeptID());
				if(department != null) {
					department.removeEmployee(employee);
					session.remove(employee);
					session.update(department);
				}
			}
			transaction.commit();
		}
		catch(HibernateException he) {
			if(transaction != null)
				transaction.rollback();
		}
		finally {
			if(session != null)
				session.close();
		}
	}
	
	
	public void closeDepartment(int deptID) {
		Session session = getSf().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			DepartmentPOJO department = session.get(DepartmentPOJO.class, deptID);
			if(department != null)
				session.delete(department);
			transaction.commit();
		}
		catch(HibernateException he) {
			if(transaction != null)
				transaction.rollback();
		}
		finally {
			if(session != null)
				session.close();
		}
		
	}
	
}

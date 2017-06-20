package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.HibernateException;

import dao.DepartmentDAO;
import pojo.DepartmentPOJO;
import pojo.EmployeePOJO;

public class FireEmployeeTester {
	public static void main(String[] args) {
		getSf();
		DepartmentDAO departmentDAO;
		DepartmentPOJO department;
		try(Scanner sc = new Scanner(System.in)) {
			departmentDAO = new DepartmentDAO();
//			System.out.println("Enter the Department Number : ");
//			int deptid = sc.nextInt();
		

			System.out.print("Enter empID to fire: ");
			
			departmentDAO.fireEmployee(sc.nextInt());
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			getSf().close();
		}
	}
}

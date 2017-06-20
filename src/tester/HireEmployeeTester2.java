package tester;

import static utils.HibernateUtils.*;

import java.util.Scanner;

import org.hibernate.HibernateException;

import dao.DepartmentDAO;
import pojo.DepartmentPOJO;
import pojo.EmployeePOJO;


public class HireEmployeeTester2 {
	public static void main(String[] args) {
		getSf();
		DepartmentDAO departmentDAO;
		DepartmentPOJO department;
		try(Scanner sc = new Scanner(System.in)) {
			departmentDAO = new DepartmentDAO();
			System.out.println("Enter the Department Number : ");
			int deptid = sc.nextInt();
		

			System.out.println("Enter empName empCity empSalary. Type 'quit' to exit ");
			
			departmentDAO.hireEmployee2(deptid, new EmployeePOJO(sc.next(),sc.next(), sc.nextDouble()));
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			getSf().close();
		}
	}
}
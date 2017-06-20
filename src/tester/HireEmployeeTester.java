package tester;

import static utils.HibernateUtils.*;

import java.util.Scanner;

import org.hibernate.HibernateException;

import dao.DepartmentDAO;
import pojo.DepartmentPOJO;
import pojo.EmployeePOJO;


public class HireEmployeeTester {
	public static void main(String[] args) {
		getSf();
		DepartmentDAO departmentDAO;
		DepartmentPOJO department;
		try(Scanner sc = new Scanner(System.in)) {
			departmentDAO = new DepartmentDAO();
			System.out.println("Enter the Department Number : ");
			department = departmentDAO.getDepartment(sc.nextInt());
			System.out.println("department = "+department.toString());
			while(true) {
				System.out.println("Enter empName empCity empSalary. Type 'quit' to exit ");
				String empName = sc.next(); 
				if(empName.equals("quit"))
					break;
				department.addEmployee(new EmployeePOJO(empName, sc.next(), sc.nextDouble()));
			}
			departmentDAO.hireEmployee(department);
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			getSf().close();
		}
	}
}
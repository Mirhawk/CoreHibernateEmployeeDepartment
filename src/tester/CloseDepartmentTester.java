package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.HibernateException;

import dao.DepartmentDAO;

public class CloseDepartmentTester {
	public static void main(String[] args) {
		getSf();
		DepartmentDAO departmentDAO;

		try(Scanner sc = new Scanner(System.in)) {
			departmentDAO = new DepartmentDAO();
			System.out.println("Enter the Department ID to be closed : ");
			departmentDAO.closeDepartment(sc.nextInt());
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			getSf().close();
		}
	}
}

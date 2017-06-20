package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.HibernateException;

import dao.DepartmentDAO;

public class ShowDepartmentsTester {
	public static void main(String[] args) {
		getSf();
		DepartmentDAO departmentDAO;
	
		try(Scanner sc = new Scanner(System.in)) {
			departmentDAO = new DepartmentDAO();
			System.out.print("Enter departemntID to show details of: ");
			System.out.println(departmentDAO.getDepartment(sc.nextInt()));
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			getSf().close();
		}
	}
}

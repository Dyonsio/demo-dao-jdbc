package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("\n=== TEST 1: department insert ====");
		
		Department department = new Department (null, "Music");
		departmentDao.insert(department);
		System.out.println("Inserted! New id = " + department.getId());
		
		System.out.println("\n=== TEST 2: department UPDATE ====");
		
		Department department2 = departmentDao.findById(1);
		department2.setName("Food");
		departmentDao.update(department2);
		System.out.println("Update completo");
		
		System.out.println("\n=== TEST 3: department DELETE ====");
		
		System.out.println("Entre com Id para deletar: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completado");
		sc.close();
		
		System.out.println("=== TEST 4: department findById ====");
		
		Department dep = departmentDao.findById(3);
		System.out.println(dep);
		
		System.out.println("=== TEST 5: department findAll ====");
		
		List<Department> list = departmentDao.findAll();
		for (Department d : list) {
			System.out.println(d);
		}
		
		
	}
}

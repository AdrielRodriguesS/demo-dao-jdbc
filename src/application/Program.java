package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.criateSellerDao();
		
		System.out.println("=== TEST 1: seller find by Id ===");		
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: seller Find by Department ===");		
		Department department = new Department (2, null);		
		List <Seller> list = sellerDao.findByDepartment(department);
		
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: seller Find All ===");				
		list = sellerDao.findAll();
		
		for (Seller obj : list) {
			System.out.println(obj);
		}

	}

}

package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.criateSellerDao();
		
		System.out.println("=== TEST 1: seller by Id ===");		
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
	}

}

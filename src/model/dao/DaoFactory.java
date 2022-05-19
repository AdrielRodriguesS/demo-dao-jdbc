package model.dao;

import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
	
	// esse método é utilizado para criar uma interface (SellerDao) e instanciar uma implementação (SellerDaoJDBC)
	//é utilizado para não expor a implementação, somente expor a interface.
	public static SellerDao criateSellerDao () {
		return new SellerDaoJDBC();
	}

}

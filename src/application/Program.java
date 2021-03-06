package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		SellerDAO sellerDao = DaoFactory.createSellerDao();
		System.out.println("=== TESTE N� 1: seller findByID ===");
		Seller seller = sellerDao.findById(3);

		System.out.println(seller);

		System.out.println("\n=== TESTE N� 2: seller findByDepartment ===");

		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n=== TESTE N� 3: seller findAll ===");

		
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		
		System.out.println("\n === TESTE 4: seller insert ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted, new Id = " + newSeller.getId());
		
		System.out.println("\n === TESTE 5: seller update ===");
		
		seller = sellerDao.findById(1);
		//System.out.println(seller);
		seller.setName("Martha Waine");
		System.out.println(seller);
		sellerDao.update(seller);
		System.out.println("Update Completed!");
		
		
		System.out.println("=== test 6: seller delete ====");
		System.out.println("Informe o id do seller para ser deletado");
		
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed!");
		
		sc.close();
		
		
	}

}

package model.dao;

import java.util.List;

import model.entities.Seller;


public interface SellerDAO {
	void insert(SellerDAO obj);

	void update(SellerDAO obj);

	void deleteById(Integer id);

	Seller findById(Integer id);

	List<Seller> findAll();

}

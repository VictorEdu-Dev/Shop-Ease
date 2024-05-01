package com.shopease.persistence.repository.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.shopease.controller.system.stock.Product;
import com.shopease.persistence.repository.CrudRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class JpaProductDAO implements CrudRepository<Product, String, Object> {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Product findById(Product arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findByObject(Product arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findListObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(Product arg) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Product arg1, Map<String, Object> arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Product arg) {
		// TODO Auto-generated method stub
		return false;
	}
}

package com.shopease.persistence.repository.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.shopease.persistence.model.admin.AdminUser;
import com.shopease.persistence.repository.CrudRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class JpaAuthSessionDAO implements CrudRepository<AdminUser, String, Object> {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public AdminUser findById(AdminUser user) {
		return manager.find(AdminUser.class, user);
	}
	
	@Override
	public AdminUser findByObject(AdminUser user) {
		String queryString = "SELECT au FROM AdminUser au WHERE au.username = :username AND au.password = :password";
        TypedQuery<AdminUser> query = manager.createQuery(queryString, AdminUser.class);
        query.setParameter("username", user.getUsername());
        query.setParameter("password", user.getPassword());
        try {
        	return query.getSingleResult();
        } catch (NoResultException e) {
        	return null;
        }
		
	}

	@Override
	public boolean save(AdminUser user) {
		manager.persist(user);
		return false;
	}

	@Override
	public boolean update(AdminUser user, Map<String, Object> map) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(AdminUser user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<AdminUser> findListObject() {
		// TODO Auto-generated method stub
		return null;
	}
}

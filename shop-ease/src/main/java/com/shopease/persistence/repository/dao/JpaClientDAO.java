package com.shopease.persistence.repository.dao;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.shopease.persistence.model.usercommon.Client;
import com.shopease.persistence.repository.CrudRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class JpaClientDAO implements CrudRepository<Client, String, Object> {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Client findById(Client arg) {
		return manager.find(Client.class, arg);
	}

	@Override
	public Client findByObject(Client arg) {
		String queryString = "SELECT au FROM Client au WHERE au.name = :name AND au.email = :email";
        TypedQuery<Client> query = manager.createQuery(queryString, Client.class);
        query.setParameter("name", arg.getUsername());
        query.setParameter("email", arg.getPassword());
        try {
        	return query.getSingleResult();
        } catch(NoResultException e) {
        	return null;
        }
	}
	
	@Override
	public List<Client> findListObject() {
		String jpql = "SELECT e FROM Client e";
        Query query = manager.createQuery(jpql, Client.class);
        try {
        	 List<?> resultList = query.getResultList();
             List<Client> clients = new ArrayList<>();
             for (Object obj : resultList) {
                 if (obj instanceof Client) {
                     clients.add((Client) obj);
                 }
             }
             return clients;
        } catch(PersistenceException e) {
        	return null;
        }
	}

	@Override
	public boolean save(Client arg) {
		manager.persist(arg);
		return manager.contains(arg);
	}

	@Override
	public boolean update(Client arg, Map<String, Object> map) {
		try {
			for(Map.Entry<String, Object> entry : map.entrySet()) {
				String attributeName = entry.getKey();
				Object newValue = entry.getKey();
				
				Field field = arg.getClass().getDeclaredField(attributeName);
				field.setAccessible(true);
				field.set(arg, newValue);
			}
		} catch (NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
			return manager.contains(arg);
		}
		
		manager.merge(arg);
		return manager.contains(arg);
	}

	@Override
	public boolean delete(Client arg) {
		manager.remove(arg);
		return manager.contains(arg);
	}

}

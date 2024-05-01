package com.shopease.persistence.repository.dao;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.shopease.persistence.model.admin.Employee;
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
public class JpaEmployeeDAO implements CrudRepository<Employee, String, Object> {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Employee findById(Employee arg) {
		return manager.find(Employee.class, arg);
	}

	@Override
	public Employee findByObject(Employee arg) {
		String queryString = "SELECT au FROM Client au WHERE au.name = :name";
        TypedQuery<Employee> query = manager.createQuery(queryString, Employee.class);
        query.setParameter("name", arg.getName());
        try {
        	return query.getSingleResult();
        } catch(NoResultException e) {
        	return null;
        }
	}

	@Override
	public List<Employee> findListObject() {
		String jpql = "SELECT e FROM Employee e";
        Query query = manager.createQuery(jpql, Client.class);
        try {
        	 List<?> resultList = query.getResultList();
             List<Employee> employees = new ArrayList<>();
             for (Object obj : resultList) {
                 if (obj instanceof Employee) {
                	 employees.add((Employee) obj);
                 }
             }
             return employees;
        } catch(PersistenceException e) {
        	e.printStackTrace();
        	return null;
        }
	}

	@Override
	public boolean save(Employee arg) {
		if(arg != null) {
			manager.persist(arg);
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Employee arg, Map<String, Object> map) {
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
			return false;
		}
		
		manager.merge(arg);
		return true;
	}

	@Override
	public boolean delete(Employee arg) {
		if(arg != null) {
			manager.remove(arg);
			return true;
		}
		return false;
	}

}

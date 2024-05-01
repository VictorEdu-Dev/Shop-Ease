package com.shopease.persistence.repository;

import java.util.List;
import java.util.Map;

public interface CrudRepository<T, K, V> {
	public T findById(T arg);
	public T findByObject(T arg);
	public List<T> findListObject();
	public boolean save(T arg);
	public boolean update(T arg1, Map<K, V> arg2);
	public boolean delete(T arg);
	
}

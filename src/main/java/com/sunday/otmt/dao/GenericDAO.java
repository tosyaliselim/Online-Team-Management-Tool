package com.sunday.otmt.dao;

import java.util.List;

public interface GenericDAO<T> {
	
	public T save(T entity);
	public T getEntityById(int id);
	public List<T> getAllEntities();
	public void delete(int id);
	default public T getEntityByName(String name) { return null; };
	
}
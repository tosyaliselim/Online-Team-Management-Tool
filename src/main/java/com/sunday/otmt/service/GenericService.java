package com.sunday.otmt.service;

import java.util.List;

public interface GenericService<T> {
	
	public T save(T entity);
	public T getEntityById(int id);
	public List<T> getAllEntities();
	public void delete(int id);
	
}
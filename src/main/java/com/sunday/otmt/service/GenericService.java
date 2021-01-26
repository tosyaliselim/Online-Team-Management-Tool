package com.sunday.otmt.service;

import java.util.List;

import com.sunday.otmt.exception.EntityNotFoundException;

public interface GenericService<T> {
	
	public T save(T entity);
	public T getById(int id);
	public List<T> getAll();
	public void delete(int id);
	default public T getByName(String name) throws EntityNotFoundException { return null; };
	
}
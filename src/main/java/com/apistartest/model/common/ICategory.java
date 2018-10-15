package com.apistartest.model.common;

import java.util.List;

public interface ICategory<T> {

	T findById(final String id);
	
	T findByName(final String name);

	List<T> findAll();

	T create(final T entity);

	void deleteById(final String entityId);
}
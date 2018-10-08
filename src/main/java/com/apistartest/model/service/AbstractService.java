package com.apistartest.model.service;

import java.util.List;

import com.apistartest.model.common.ICategory;
import com.apistartest.model.dao.AbstractDao;


public abstract class AbstractService<T> implements ICategory<T> {

	public abstract AbstractDao<T> getDao();

	@Override
	public T findById(String id) {
		return getDao().findById(id);
	}

	@Override
	public List<T> findAll() {
		return getDao().findAll();
	}

	@Override
	public T create(T entity) {
		return getDao().create(entity);
	}

	@Override
	public void delete(T entity) {
		getDao().delete(entity);
	}

	@Override
	public void deleteById(String entityId) {
		getDao().deleteById(entityId);
	}
}
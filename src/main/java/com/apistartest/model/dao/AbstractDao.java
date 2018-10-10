package com.apistartest.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import com.apistartest.model.common.ICategory;


public abstract class AbstractDao<T> implements ICategory<T> {

	private Class<T> entityClass;

	public AbstractDao(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public T findById(String entityId) {
		Query<T> query = getDatastore().find(entityClass, "_id",entityId);
		return (T) query.get();
	}
	
	@Override
	public T findByName(String name) {
		Query<T> query = getDatastore().find(entityClass,"name",name);
		return (T) query.get();
		
	}

	@Override
	public List<T> findAll() {
		List<T> list = new ArrayList<T>();
		list = getDatastore().find(entityClass).asList();
		return list;
	}

	@Override
	public T create(T entity) {
		getDatastore().save(entity);
		return entity;
	}

	@Override
	public void delete(T entity) {
		getDatastore().delete(entity);
	}

	@Override
	public void deleteById(String entityId) {
		getDatastore().delete(entityClass, new ObjectId(entityId));
	}

	public abstract Datastore getDatastore();
}

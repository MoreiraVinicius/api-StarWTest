package com.apistartest.model.dao.impl;

import org.mongodb.morphia.Datastore;

import com.apistartest.config.IConnectionDB;
import com.apistartest.model.dao.AbstractDao;
import com.apistartest.model.dao.IPlanetDao;
import com.apistartest.model.entity.Planet;
import com.google.inject.Inject;
import com.google.inject.Singleton;


@Singleton
public class PlanetDao extends AbstractDao<Planet> implements IPlanetDao {

	@Inject
	public IConnectionDB mongoConnection;

	public PlanetDao() {
		super(Planet.class);
	}

	@Override
	public Datastore getDatastore() {
		return mongoConnection.getConnection();
	}

}

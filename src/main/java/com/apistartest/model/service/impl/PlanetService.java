package com.apistartest.model.service.impl;

import com.apistartest.model.dao.AbstractDao;
import com.apistartest.model.dao.IPlanetDao;
import com.apistartest.model.entity.Planet;
import com.apistartest.model.service.AbstractService;
import com.apistartest.model.service.IPlanetService;
import com.google.inject.Inject;
import com.google.inject.Singleton;


@Singleton
public class PlanetService extends AbstractService<Planet> implements IPlanetService{

	private IPlanetDao planetDao;
	
	@Inject
	public PlanetService(IPlanetDao planetDao) {
		this.planetDao = planetDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public AbstractDao<Planet> getDao() {
		return (AbstractDao<Planet>) planetDao;
	}
}
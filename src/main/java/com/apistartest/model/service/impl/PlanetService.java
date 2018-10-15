package com.apistartest.model.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.apistartest.exceptions.BadRequest;
import com.apistartest.model.dao.AbstractDao;
import com.apistartest.model.dao.IPlanetDao;
import com.apistartest.model.entity.Planet;
import com.apistartest.model.service.AbstractService;
import com.apistartest.model.service.IPlanetService;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import restql.core.RestQL;
import restql.core.config.ClassConfigRepository;
import restql.core.response.QueryItemResponse;
import restql.core.response.QueryResponse;

import com.apistartest.exceptions.BadRequest;

@Singleton
public class PlanetService<K, V> extends AbstractService<Planet> implements IPlanetService {

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

	@Override
	public int findAppearancesByName(String name) {
		ClassConfigRepository config = new ClassConfigRepository();
		config.put("planets", "https://swapi.co/api/planets/");
		RestQL restQL = new RestQL(config);
		QueryResponse response = restQL.executeQuery("from planets as foundPlanet with search = ? only results.films",
				name);
		QueryItemResponse queryItem = response.get("foundPlanet", QueryItemResponse.class);

		ArrayList results = (ArrayList) queryItem.getResult(HashMap.class).get("results");
		if (!results.isEmpty()) {
			LinkedHashMap<K, V> countAppearances = (LinkedHashMap<K, V>) results.get(0);
			ArrayList films = (ArrayList) countAppearances.get("films");
			return films.size();
		} else {
			return 0;
		}
	}

	public Planet checkValues(Planet obj) {
		try {
			if (obj.getName().isEmpty() || obj.getName().equals(null)) {
				throw new BadRequest("Campo nome vazio");
			}
			if (obj.getClimate().isEmpty() || obj.getClimate().equals(null)) {
				throw new BadRequest("Campo clima vazio");
			}
			if (obj.getTerrain().isEmpty() || obj.getTerrain().equals(null)) {
				throw new BadRequest("Campo terreno vazio");
			}
		} catch (Exception e) {

			throw new BadRequest("Erro ao inserir null");
		}
		return obj;
	}
}
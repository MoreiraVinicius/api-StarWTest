package com.apistartest.model.service;

import com.apistartest.model.common.ICategory;
import com.apistartest.model.entity.Planet;

public interface IPlanetService extends ICategory<Planet> {
	public Planet checkValues(Planet obj);
	public int findAppearancesByName(String name);
}

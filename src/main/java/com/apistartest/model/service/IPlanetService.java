package com.apistartest.model.service;

import com.apistartest.model.common.ICategory;
import com.apistartest.model.entity.Planet;
import com.apistartest.exceptions.BadRequest;

public interface IPlanetService extends ICategory<Planet> {
	public default Planet checkValues(Planet obj) {
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

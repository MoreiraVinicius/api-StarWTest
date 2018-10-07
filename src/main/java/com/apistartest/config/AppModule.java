/**
 * 
 */
package com.apistartest.config;

import com.apistartest.model.dao.IPlanetDao;
import com.apistartest.model.service.IPlanetService;
import com.apistartest.model.dao.impl.PlanetDao;
import com.apistartest.model.service.impl.PlanetService;
import com.google.inject.AbstractModule;


public class AppModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(IPlanetDao.class).to(PlanetDao.class);
		bind(IPlanetService.class).to(PlanetService.class);
		bind(IConnectionDB.class).to(MongoDBConnection.class);
	}
}

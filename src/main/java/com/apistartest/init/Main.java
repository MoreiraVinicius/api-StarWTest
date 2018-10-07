package com.apistartest.init;

import static spark.Spark.port;

import java.util.logging.Logger;

import com.apistartest.config.AppModule;
import com.apistartest.routes.PlanetRoutes;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
	static final Logger LOGGER = Logger.getLogger(Main.class.getName());
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		port(8081);

		Injector injector = Guice.createInjector(new AppModule());
		PlanetRoutes controller = injector.getInstance(PlanetRoutes.class);

		new PlanetRoutes();
		
		LOGGER.info(" --------- Init Jetty Server - Api StarWtest On --------- ");
	}
}

package com.apistartest.routes;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;

import com.apistartest.model.entity.Planet;
import com.apistartest.model.service.IPlanetService;
import com.apistartest.util.JsonTransformer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;

public class PlanetRoutes {

	@Inject
	private IPlanetService planetService;

	private static final String API_CONTEXT = "apistartest/";

	private static final String API_CATEGORY = "planets";

	public PlanetRoutes() {

		JsonTransformer jsonTransformer = new JsonTransformer();

		// Get all
		get(API_CONTEXT + API_CATEGORY, (request, response) -> planetService.findAll(),
				jsonTransformer::render);

		// Get by id
		get(API_CONTEXT + API_CATEGORY + "/:id", (request, response) -> {
			try {
				String id = request.params(":id");
				Planet planet = planetService.findById(id);
				if (planet != null) {
					return planet;
				}
				return planet;
			} catch (Exception e) {
				response.status(500);
				return e.getMessage();
			}
		}, jsonTransformer::render);

		// Post
		post(API_CONTEXT + API_CATEGORY, (request, response) -> {
			try {
				ObjectMapper mapper = new ObjectMapper();
				Planet planet = mapper.readValue(request.body(), Planet.class);
				planet = planetService.create(planet);
				response.status(201);
				response.type("application/json");
				return planet;
			} catch (Exception e) {
				response.status(500);
				return e.getMessage();
			}
		}, jsonTransformer::render);

		// Delete
		delete(API_CONTEXT + API_CATEGORY + "/:id", (request, response) -> {
			String id = request.params(":id");
			planetService.deleteById(id);
			return "Planet deleted!!!";
		});

		// Test requests...
		get("/test", (request, response) -> "Jetty Server On!!!");
	}
}

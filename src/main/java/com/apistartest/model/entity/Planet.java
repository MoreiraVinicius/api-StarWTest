package com.apistartest.model.entity;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;


@Entity(value="planets", noClassnameStored = true)
public class Planet {

	@Id
	private String id = new ObjectId().toString();
	
	private String name;
	
	private String climate;
	
	private String terrain;

	private int AppearancesFilms;

	
	public int getAppearancesFilms() {
		return AppearancesFilms;
	}


	public void setAppearancesFilms(int appearancesFilms) {
		AppearancesFilms = appearancesFilms;
	}


	public String getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTerrain() {
		return terrain;
	}

	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}
	
	public String getClimate() {
		return climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id.toString() == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planet other = (Planet) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("Planet: [id=").append(id.toString()).append(", name=").append(name).append("]");
		return builder.toString();
	}

}
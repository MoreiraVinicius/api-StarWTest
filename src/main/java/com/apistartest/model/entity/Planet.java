package com.apistartest.model.entity;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.PostLoad;
import org.mongodb.morphia.annotations.PostPersist;
import org.mongodb.morphia.annotations.Transient;


@Entity("planets")
public class Planet {

	@Id
	private ObjectId id;

	@Transient
	private String idHex;
	
	private String name;
	
	private String climate;
	
	private String terrain;
	
	

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
	

	public String getIdHex() {
		return idHex;
	}

	public void setIdHex(String idHex) {
		this.idHex = idHex;
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

	@PostLoad
	@PostPersist
	private void loadIdHex() {
		if(id != null)
			setIdHex(id.toString());
	}

}
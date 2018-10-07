package com.apistartest.config;

import org.mongodb.morphia.Datastore;


public interface IConnectionDB {
	public Datastore getConnection();
	public void closeConnetion();
}

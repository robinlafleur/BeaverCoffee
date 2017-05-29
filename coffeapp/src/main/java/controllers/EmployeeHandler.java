package controllers;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import database.DatabaseConnector;

public class EmployeeHandler {
	private DatabaseConnector dc;
	private PanelSwitcher ps;
	
	public EmployeeHandler(DatabaseConnector dc, PanelSwitcher ps) {
		this.dc = dc;
		this.ps = ps;
	}
	
	public MongoCollection<Document> getEmployees() {
		dc.setCollection("Employee");
		return dc.getCollection();
	}
}

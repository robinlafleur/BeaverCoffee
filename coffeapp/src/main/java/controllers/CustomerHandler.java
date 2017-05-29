package controllers;

import gui.CreateCustomerPanel;

import static com.mongodb.client.model.Filters.eq;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import database.DatabaseConnector;

public class CustomerHandler {
	private DatabaseConnector dc;
	private CreateCustomerPanel cc;
	
	public CustomerHandler(DatabaseConnector dc, CreateCustomerPanel cc){
		this.dc = dc;
		this.cc = cc;
		
		cc.getBtnEnter().addActionListener(new CustomerInformationListener());
	}
	
	public MongoCollection<Document> getCustomers() {
		dc.setCollection("Customers");
		return dc.getCollection();
	}
	
	public void addCustomer(String[] data){
		dc.setCollection("Customers");
		MongoCollection<Document> mc = dc.getCollection();
		
		Document document = new Document("name", data[0]).append("ID", data[1]).append("Address", data[2]).append("Occupation", data[3]);
		mc.insertOne(document);
		
		dc.printTest();
	}
	
	public void updateCustomer(String[] data){
		dc.setCollection("Customers");
		MongoCollection<Document> mc = dc.getCollection();
		
		Document d1 = new Document("name", data[0]);
		Document d2 = new Document("$set", new Document("ID", data[1]));
		Document d3 = new Document("$set", new Document("address", data[2]));
		Document d4 = new Document("$set", new Document("Occupation", data[3]));
		mc.updateOne(d1, d2);
		mc.updateOne(d1, d3);
		mc.updateOne(d1, d4);
	}
	
	private class CustomerInformationListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			addCustomer(cc.getTextFieldData());
		}
	}
	
}

package controllers;

import gui.CreateCustomerPanel;

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
	
	public void addCustomer(String[] data){
		dc.setCollection("Customers");
		MongoCollection<Document> mc = dc.getCollection();
		
		Document document = new Document("name", data[0]).append("ID", data[1]).append("Address", data[2]).append("Occupation", data[3]);
		mc.insertOne(document);
		
		dc.printTest();
	}
	
	private class CustomerInformationListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			addCustomer(cc.getTextFieldData());
		}
	}
}

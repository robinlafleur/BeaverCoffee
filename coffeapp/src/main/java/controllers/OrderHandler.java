package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import database.DatabaseConnector;

import static com.mongodb.client.model.Filters.*;

public class OrderHandler {
	private DatabaseConnector dc;
	private PanelSwitcher ps;
	
	public OrderHandler(DatabaseConnector dc, PanelSwitcher ps){
		this.dc = dc;
		this.ps = ps;
	}
	
	public MongoCollection<Document> getProducts(){
		dc.setCollection("Products");
		return dc.getCollection();
	}
	
	public boolean updateProductQuantity(String name, int quantityRemoved){
		dc.setCollection("Products");
		MongoCollection<Document> mc = dc.getCollection();
		
		Document d = mc.find(eq("name", name)).first();
		int curQuantity = d.getInteger("quantity");
		
		if(quantityRemoved <= curQuantity){
			Document d1 = new Document("name", name);
			Document d2 = new Document("$set", new Document("quantity", curQuantity-quantityRemoved));
			mc.updateOne(d1, d2);
			return true;
		}
		
		return false;
	}
	
	private class PlaceOrderListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			
		}
	}
	
	public static void main(String[] args){
		OrderHandler oh = new OrderHandler(new DatabaseConnector("BeaverCoffeeDatabase"), new PanelSwitcher());
		oh.updateProductQuantity("Espresso Roast", 5);
	}
}

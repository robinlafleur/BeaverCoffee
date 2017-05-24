package controllers;

import static com.mongodb.client.model.Filters.eq;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import database.DatabaseConnector;

public class OrderHandler {
	private DatabaseConnector dc;
	private PanelSwitcher ps;
	
	public OrderHandler(DatabaseConnector dc, PanelSwitcher ps){
		this.dc = dc;
		this.ps = ps;
		
		new PlaceOrderListener();
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
		
		public PlaceOrderListener(){
			createOrder();
		}
		
		public void actionPerformed(ActionEvent e) {
			
			
		}
		
		private void createOrder(){
			dc.setCollection("Orders");
			MongoCollection<Document> mc = dc.getCollection();
			
			Document d = new Document("customerID", "asdsadasd");
			HashMap<String, Integer> products = handleInput();
			
			Iterator it = products.entrySet().iterator();
			while(it.hasNext()){
				Map.Entry pair = (Map.Entry)it.next();
				System.out.println(pair.getKey() + ": " +pair.getValue());
			}
			
		}
		
		private HashMap<String, Integer> handleInput(){
			HashMap<String, Integer> products = new HashMap<String, Integer>();
			products.put("coffee", 10);
			products.put("some other", 2);
			return products;
		}
	}
	
	public static void main(String[] args){
		OrderHandler oh = new OrderHandler(new DatabaseConnector("BeaverCoffeeDatabase"), new PanelSwitcher());
		oh.updateProductQuantity("Espresso Roast", 5);
	}
}

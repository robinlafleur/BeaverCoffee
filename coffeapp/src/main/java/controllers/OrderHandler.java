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
			updateProduct(name, new Document("quantity", curQuantity-quantityRemoved));
			return true;
		}
		
		return false;
	}
	
	public void updateProductQuantityManager(String name, int quiantity){
		dc.setCollection("Products");
		MongoCollection<Document> mc = dc.getCollection();
		updateProduct(name, new Document("quantity", quiantity));
	}
	
	public void updateProduct(String name, Document d2){
		dc.setCollection("Products");
		MongoCollection<Document> mc = dc.getCollection();
		
		Document d1 = new Document("name", name);
		Document change = new Document("$set", d2);
		mc.updateOne(d1, change);
		
	}
	
	public void deleteProduct(String name){
		dc.setCollection("Products");
		MongoCollection<Document> mc = dc.getCollection();
		
		mc.deleteOne(new Document("name", name));
	}
	
	public void updateOrder(String customerID){
		dc.setCollection("Orders");
		MongoCollection<Document> mc = dc.getCollection();
		
		
	}
	
	private class PlaceOrderListener implements ActionListener{
		
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
				updateProductQuantity((String)pair.getKey(), (Integer)pair.getValue());
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

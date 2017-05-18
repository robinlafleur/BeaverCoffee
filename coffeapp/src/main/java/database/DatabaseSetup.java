package database;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

public class DatabaseSetup {
	
	public DatabaseSetup(){
		init();
	}
	
	private void init(){
		DatabaseConnector dc = new DatabaseConnector("BeaverCoffeeDatabase");
		
		dc.setCollection("BeaverColTest");
		MongoCollection<Document> col = dc.getCollection();
		col.drop();
		
		Document d = new Document("user1", "password1");
		Document d2 = new Document("user2", "password2");
		col.insertOne(d);
		col.insertOne(d2);
		
		
	}
	
	public static void main(String[] args){
		new DatabaseSetup();
	}
	
}

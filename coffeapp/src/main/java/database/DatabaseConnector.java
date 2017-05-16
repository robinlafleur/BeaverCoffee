package database;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DatabaseConnector {
	private MongoClient client;
	private MongoDatabase database;
	
	public DatabaseConnector(){
		this("localhost", 27017);
	}
	
	public DatabaseConnector(String host, int port){
		int p = 0;
		try{
			p = port;
			client = new MongoClient(host, p);
		}catch(NumberFormatException e){
			System.err.println("Port must be of type int");
		}
	}
	
	public void setCurrentDatabase(String databaseName){
		database = client.getDatabase(databaseName);
	}
	
	public MongoDatabase getCurrentDatabase(){
		return database;
	}
	
	//Test
	public static void main(String[] args){
		DatabaseConnector dc = new DatabaseConnector();
		dc.setCurrentDatabase("test");
		MongoDatabase db = dc.getCurrentDatabase();
		
		MongoCollection<Document> collection = db.getCollection("users");
		System.out.println(collection.find().first().toJson());
		
	}
}

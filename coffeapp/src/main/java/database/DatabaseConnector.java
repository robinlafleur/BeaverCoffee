package database;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;

public class DatabaseConnector {
	private MongoDatabase database;
	private MongoCollection<Document> collection;
	
	public DatabaseConnector(String database){
		this(database, "localhost", 27017);
	}
	
	public DatabaseConnector(String database, String host, int port){
		MongoClient client = null;
		int p = 0;
		try{
			p = port;
			client = new MongoClient(host, p);
		}catch(NumberFormatException e){
			System.err.println("Port must be of type int");
		}
		
		this.database = client.getDatabase(database);
	}
	
	public void setCollection(String collection){
		this.collection = database.getCollection(collection);
	}
	
	public MongoCollection<Document> getCollection(){
		return this.collection;
	}
	
	
	public void printTest(){
		Block<Document> printBlock = new Block<Document>() {
			
		       public void apply(final Document document) {
		           System.out.println(document.toJson());
		       }
		};
		
		collection.find().forEach(printBlock);
	}
	
	
	
	
	//Test
	public static void main(String[] args){
		DatabaseConnector dc = new DatabaseConnector();
		dc.printTest();
		
		
		
	}
}

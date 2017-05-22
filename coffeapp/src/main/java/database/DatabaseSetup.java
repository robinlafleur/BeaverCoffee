package database;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

public class DatabaseSetup {
	
	public DatabaseSetup(){
		init();
	}
	
	private void init(){
		DatabaseConnector dc = new DatabaseConnector("BeaverCoffeeDatabase");
		
		dc.setCollection("Customers");
		MongoCollection<Document> col = dc.getCollection();
		col.drop();
		
		Document cust1 = new Document("name", "John Smith").append("SSN", "1234567").append("address", "Street 1, 23456, Chicago");
		Document cust2 = new Document("name", "Jane Doe").append("ID", "23451").append("address", "Ave 1, 34567, London");
		Document cust3 = new Document("name", "Gun Gunnarsson").append("persnr", "640101-1234").append("address", "Malm�gatan 1, 12345, Malmö");
		Document cust4 = new Document("name", "John Johnsson").append("SSN", "7654321").append("address", "Colonoscostreet, 13456, Minneapolis");
		List<Document> l = new ArrayList<Document>();
		l.add(cust1);
		l.add(cust2);
		l.add(cust3);
		l.add(cust4);
		col.insertMany(l);
		
		dc.setCollection("Employee");
		col = dc.getCollection();
		col.drop();
		
		Document emp1 = new Document("name", "Heres Johnny").append("SSN", "8765432").append("address", "Elm Street 2, 23456, Chicago");
		Document emp2 = new Document("name", "John Smith").append("ID", "52346").append("address", "Cloverfield Lane, 34567, London");
		Document emp3 = new Document("name", "Gun Gunnarsson").append("persnr", "640101-1234").append("address", "Malm�gatan 1, 12345, Malmö");
		Document emp4 = new Document("name", "Ellen Ripley").append("SSN", "2345678").append("address", "Nostromo 23, 13456, Minneapolis");
		l = new ArrayList<Document>();
		l.add(emp1);
		l.add(emp2);
		l.add(emp3);
		l.add(emp4);
		col.insertMany(l);
		
		dc.setCollection("Manager");
		col = dc.getCollection();
		col.drop();
		
		Document man1 = new Document("name", "Heres Johnny").append("SSN", "8765432").append("address", "Elm Street 2, 23456, Chicago");
		Document man2 = new Document("name", "John Smith").append("ID", "52346").append("address", "Cloverfield Lane, 34567, London");
		Document man3 = new Document("name", "Gun Gunnarsson").append("persnr", "640101-1234").append("address", "Malm�gatan 1, 12345, Malmö");
		Document man4 = new Document("name", "Ellen Ripley").append("SSN", "2345678").append("address", "Nostromo 23, 13456, Minneapolis");
		l = new ArrayList<Document>();
		l.add(man1);
		l.add(man2);
		l.add(man3);
		l.add(man4);
		col.insertMany(l);
		
		dc.setCollection("Employer");
		col = dc.getCollection();
		col.drop();
		
		Document employer = new Document("name", "Iron Fist").append("persnr", "660606-6666").append("adress", "Dantes Inferno 1, 666 66, Malmö");
		col.insertOne(employer);
		
	}
	
	public static void main(String[] args){
		new DatabaseSetup();
	}
	
}

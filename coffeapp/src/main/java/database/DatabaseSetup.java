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
		
		Document emp1 = new Document("name", "Heres Johnny").append("SSN", "8765432").append("address", "Elm Street 2, 23456, Chicago").
				append("username", "heresjohnny").append("password", "pwhash");
		Document emp2 = new Document("name", "John Smith").append("ID", "52346").append("address", "Cloverfield Lane, 34567, London").
				append("username", "johnsmith").append("password", "pwhash");
		Document emp3 = new Document("name", "Gun Gunnarsson").append("persnr", "640201-5634").append("address", "Malm�gatan 1, 12345, Malmö").
				append("username", "gungunnarsson").append("password", "pwhash");
		Document emp4 = new Document("name", "Ellen Ripley").append("SSN", "2345678").append("address", "Nostromo 23, 13456, Minneapolis").
				 				append("username", "ellenripley").append("password", "pwhash");
		l = new ArrayList<Document>();
		l.add(emp1);
		l.add(emp2);
		l.add(emp3);
		l.add(emp4);
		col.insertMany(l);
		
		dc.setCollection("Manager");
		col = dc.getCollection();
		col.drop();
		
		Document man1 = new Document("name", "Heres Johnny").append("SSN", "8765874").append("address", "Elm Street 2, 23456, Chicago").
				append("username", "heresjohnny").append("password", "pwhash");
		Document man2 = new Document("name", "John Smith").append("ID", "52348").append("address", "Cloverfield Lane, 34567, London").
				append("username", "heresjohnny").append("password", "pwhash");
		Document man3 = new Document("name", "Gun Gunnarsson").append("persnr", "641103-1256").append("address", "Malm�gatan 1, 12345, Malmö").
				append("username", "heresjohnny").append("password", "pwhash");
		Document man4 = new Document("name", "Ellen Ripley").append("SSN", "2345678").append("address", "Nostromo 23, 13456, Minneapolis").
				append("username", "heresjohnny").append("password", "pwhash");
		l = new ArrayList<Document>();
		l.add(man1);
		l.add(man2);
		l.add(man3);
		l.add(man4);
		col.insertMany(l);
		
		
		dc.setCollection("Products");
		col = dc.getCollection();
		col.drop();
		
		Document prod1 = new Document("type", "Whole-bean coffee").append("name", "Espresso Roast").append("quantity", 20);
		Document prod2 = new Document("type", "Whole-bean coffee").append("name", "Whole Bean French Roast").append("quantity", 10);
		Document prod3 = new Document("type", "Whole-bean coffee").append("name", "Whole Bean Light Roast").append("quantity", 30);
		Document prod4 = new Document("type", "Other").append("name", "Brewed Coffee").append("quantity", 30);
		Document prod5 = new Document("type", "Other").append("name", "Espresso").append("quantity", 30);
		Document prod6 = new Document("type", "Other").append("name", "Cappucino").append("quantity", 30);
		Document prod7 = new Document("type", "Other").append("name", "Latte").append("quantity", 30);
		Document prod8 = new Document("type", "Other").append("name", "Hot Chocolate").append("quantity", 10);
		Document prod9 = new Document("type", "Syrup").append("name", "Vanilla").append("quantity", 10);
		Document prod10 = new Document("type", "Syrup").append("name", "Caramell").append("quantity", 10);
		Document prod11 = new Document("type", "Syrup").append("name", "Irish Cream").append("quantity", 10);
		Document prod12 = new Document("type", "Milk").append("name", "Skim Milk").append("quantity", 20);
		Document prod13 = new Document("type", "Milk").append("name", "Soy Milk").append("quantity", 20);
		Document prod14 = new Document("type", "Milk").append("name", "Whole Milk").append("quantity", 20);
		Document prod15 = new Document("type", "Milk").append("name", "2% Milk").append("quantity", 20);
		Document prod16 = new Document("type", "Milk").append("name", "Whipped Cream").append("quantity", 30);
		
		l = new ArrayList<Document>();
		l.add(prod1);
		l.add(prod2);
		l.add(prod3);
		l.add(prod4);
		l.add(prod5);
		l.add(prod6);
		l.add(prod7);
		l.add(prod8);
		l.add(prod9);
		l.add(prod10);
		l.add(prod11);
		l.add(prod12);
		l.add(prod13);
		l.add(prod14);
		l.add(prod15);
		l.add(prod16);
		col.insertMany(l);
		System.out.println(col.find().first());
		
		
		dc.setCollection("Employer");
		col = dc.getCollection();
		col.drop();
		
		Document employer = new Document("name", "Iron Fist").append("persnr", "660606-6666").append("adress", "Dantes Inferno 1, 666 66, Malmö").
				append("username", "ironfist").append("password", "pwhash");
		col.insertOne(employer);
		
	}
	
	public static void main(String[] args){
		new DatabaseSetup();
	}
	
}

package database;

import org.bson.Document;

public class AddDocToDB {
	
	public void addCustomers() {
		Document cust1 = new Document("name", "John Smith").append("SSN", "1234567").append("address", "Street 1, 23456, Chicago");
		Document cust2 = new Document("name", "Jane Doe").append("ID", "23451").append("address", "Ave 1, 34567, London");
		Document cust3 = new Document("name", "Gun Gunnarsson").append("persnr", "640101-1234").append("address", "Malmögatan 1, 12345, Malmö");
		Document cust4 = new Document("name", "John Johnsson").append("SSN", "7654321").append("address", "Colonoscostreet, 13456, Minneapolis");
	}
	
	public void addEmployee() {
		Document emp1 = new Document("name", "Heres Johnny").append("SSN", "8765432").append("address", "Elm Street 2, 23456, Chicago");
		Document emp2 = new Document("name", "John Smith").append("ID", "52346").append("address", "Cloverfield Lane, 34567, London");
		Document emp3 = new Document("name", "Gun Gunnarsson").append("persnr", "640101-1234").append("address", "Malmögatan 1, 12345, Malmö");
		Document emp4 = new Document("name", "Ellen Ripley").append("SSN", "2345678").append("address", "Nostromo 23, 13456, Minneapolis");
	}
	
	public void addManager() {
		Document emp1 = new Document("name", "Heres Johnny").append("SSN", "8765432").append("address", "Elm Street 2, 23456, Chicago");
		Document emp2 = new Document("name", "John Smith").append("ID", "52346").append("address", "Cloverfield Lane, 34567, London");
		Document emp3 = new Document("name", "Gun Gunnarsson").append("persnr", "640101-1234").append("address", "Malmögatan 1, 12345, Malmö");
		Document emp4 = new Document("name", "Ellen Ripley").append("SSN", "2345678").append("address", "Nostromo 23, 13456, Minneapolis");
	}
	
	public void addEmployer() {
		Document employer = new Document("name", "Iron Fist").append("persnr", "660606-6666").append("adress", "Dantes Inferno 1, 666 66, Malmö");
	}

}

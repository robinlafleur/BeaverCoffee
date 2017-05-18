package controllers;

import gui.Login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.*;

import database.DatabaseConnector;

public class LoginConnector {
	private DatabaseConnector dc;
	private Login loginPnl;
	private String user = "Employee";
	
	public LoginConnector(DatabaseConnector dc, Login loginPnl){
		this.dc = dc;
		this.loginPnl = loginPnl;
		loginPnl.getBtnLogin().addActionListener(new LoginBtnListener());
		loginPnl.getCbUser().addActionListener(new UserCBListener());
	}
	
	/**
	 * Checks length of username and password.
	 * Displays error messages
	 */
	private void login(){
		String username = loginPnl.getUsername();
		String password = loginPnl.getPassword();
		
		if(username.length() < 3 || password.length() < 3){
			loginPnl.setErrorMsg("Please enter username and password");
		}else{
			dc.setCollection(user);
			
			if(authorize(username, password)){
				loginPnl.setErrorMsg("Login Successful");
				//Switch panel
			}else{
				loginPnl.setErrorMsg("Authorization failed");
			}
		}
	}
	
	/**
	 * Checks entered values against database values
	 * @param username
	 * @param password
	 * @return true/false
	 */
	private boolean authorize(String username, String password){
		MongoCollection<Document> mc = dc.getCollection();
		Document match = mc.find(eq("username", username)).first();
		
		if(match != null){
			if(match.get("password").equals(password)){
				return true;
			}
		}
		
		return false;
	}
	
	// Listener for login button
	private class LoginBtnListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			login();
		}
	}
	
	// Listener for combobox selection
	private class UserCBListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			@SuppressWarnings("unchecked")
			JComboBox<String> cb = (JComboBox<String>)e.getSource();
	        user = (String)cb.getSelectedItem();
		}
	}
	
	//Test
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DatabaseConnector dc = new DatabaseConnector("BeaverCoffeeDatabase");
		Login l = new Login(500, 400);
		LoginConnector lc = new LoginConnector(dc, l);
		
		frame.add(l);
		frame.pack();
		frame.setVisible(true);
	}
}

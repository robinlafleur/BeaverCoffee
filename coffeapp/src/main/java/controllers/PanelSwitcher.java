package controllers;

import gui.CustomerProductSelectionPanel;
import gui.Login;

import java.awt.CardLayout;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

import database.DatabaseConnector;

public class PanelSwitcher extends JPanel{
	private HashMap<String, JPanel> panelMap = new HashMap<String, JPanel>();
	
	public PanelSwitcher(){
		this.setLayout(new CardLayout());
		init();
	}
	
	private void init(){
		DatabaseConnector dc = new DatabaseConnector("BeaverCoffeeDatabase");
		
		Login login = new Login(500, 400);
		panelMap.put("Login", login);
		this.add(login, "Login");
		new LoginConnector(dc, this);
		
		CustomerProductSelectionPanel cpsp = new CustomerProductSelectionPanel(500, 400);
		panelMap.put("CPSP", cpsp);
		this.add(cpsp, "CPSP");
		
	}
	
	public void showCard(String name){
		CardLayout cl = (CardLayout)this.getLayout();
		cl.show(this, name);
	}
	
	public JPanel getPanel(String panel){
		return panelMap.get(panel);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		PanelSwitcher ps = new PanelSwitcher();
		
		frame.add(ps);
		frame.pack();
		frame.setVisible(true);
	}
}

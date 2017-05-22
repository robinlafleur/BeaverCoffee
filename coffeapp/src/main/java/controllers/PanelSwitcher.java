package controllers;

import java.awt.CardLayout;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

import database.DatabaseConnector;
import gui.CustomerProductSelectionPanel;
import gui.EmployeeMenuPanel;
import gui.Login;

public class PanelSwitcher extends JPanel{
	private HashMap<String, JPanel> panelMap = new HashMap<String, JPanel>();
	
	public PanelSwitcher(){
		this.setLayout(new CardLayout());
		init();
	}
	
	private void init(){
		Login login = new Login(500, 400, this);
		panelMap.put("Login", login);
		this.add(login, "Login");
		new LoginConnector(new DatabaseConnector("BeaverCoffeeDatabase"), this);
		
		CustomerProductSelectionPanel cpsp = new CustomerProductSelectionPanel(500, 400);
		panelMap.put("CPSP", cpsp);
		this.add(cpsp, "CPSP");
		
		EmployeeMenuPanel emp = new EmployeeMenuPanel(500,400);
		panelMap.put("employee", emp);
		this.add(emp, "employee");
		
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

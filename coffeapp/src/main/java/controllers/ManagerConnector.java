package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;

import database.DatabaseConnector;
import gui.CustomerDataPanel;
import gui.ManagerMenuPanel;

public class ManagerConnector {
	private DatabaseConnector dc;
	private PanelSwitcher ps;
	private ManagerMenuPanel manager;
	private CustomerDataPanel cdp;
	private CustomerHandler customerHandler;
	
	private JButton[] options;
	private JButton search;
	private JButton[] customerBtn;
	
	
	public ManagerConnector(DatabaseConnector dc, PanelSwitcher ps, CustomerHandler customerHandler) {
		this.dc = dc;
		this.ps = ps;
		this.customerHandler = customerHandler;
		
		manager = (ManagerMenuPanel)ps.getPanel("ManagerMenu");
		cdp = (CustomerDataPanel)ps.getPanel("CustomerData");
		options = manager.getButtons();
		
		search = cdp.getButton();
		customerBtn = cdp.getCustomerButtons();
		search.addActionListener(new CustomerDataListener());
		for(JButton btn : options) {
			btn.addActionListener(new MainMenuListener());
		}
		
		for(JButton btn : customerBtn) {
			btn.addActionListener(new CustomerCreateAndUpdateListener());
		}
	}
	
	private class MainMenuListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			checkButton(e.getSource());			
		}
		
		private void checkButton(Object o) {
			if(o == options[0]) {
				ps.showCard("EmployeeData");
			} else if(o == options[1]) {
				ps.showCard("CustomerData");
			} else if(o == options[2]) {
				ps.showCard("ProductData");
			}
		}		
	}
	
	private class CustomerDataListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(search == e.getSource()) {
				String name = cdp.getName();
				dc.setCollection("Customers");
				MongoCollection<Document> mc = dc.getCollection();
				Document d = mc.find(eq("name", name)).first();
				cdp.updateInfo(d.toString());
			}
		}
	}
	
	private class CustomerCreateAndUpdateListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			checkButton(e.getSource());
		}
		private void checkButton(Object o) {
			String[] customerInfo = cdp.getNewCustomer();
			if(o == customerBtn[0]) {
				customerHandler.addCustomer(customerInfo);
			} else if(o == customerBtn[1]) {
				customerHandler.updateCustomer(customerInfo);
			}
		}
	}
}

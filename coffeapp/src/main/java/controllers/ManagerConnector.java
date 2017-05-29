package controllers;

import static com.mongodb.client.model.Filters.eq;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

import database.DatabaseConnector;
import gui.ManagerDataAccessPanel;
import gui.ManagerMenuPanel;

public class ManagerConnector {
	private DatabaseConnector dc;
	private PanelSwitcher ps;
	private ManagerMenuPanel manager;
	private ManagerDataAccessPanel managerDataPanel;
	private CustomerHandler customerHandler;
	private String mongoCollection = "Customers";
	private JComboBox<String> itemSelection;
	
	private JButton menuBtn;
	private JButton search;
	private JButton[] updateCreateBtn;
	
	
	public ManagerConnector(DatabaseConnector dc, PanelSwitcher ps, CustomerHandler customerHandler) {
		this.dc = dc;
		this.ps = ps;
		this.customerHandler = customerHandler;
		
		manager = (ManagerMenuPanel)ps.getPanel("ManagerMenu");
		managerDataPanel = (ManagerDataAccessPanel)ps.getPanel("ManagerData");
		menuBtn = manager.getButton();
		menuBtn.addActionListener(new MainMenuListener());
		
		search = managerDataPanel.getButton();
		updateCreateBtn = managerDataPanel.getUpdateCreateButtons();
		search.addActionListener(new DataListener());
		itemSelection = managerDataPanel.getSelection();
		itemSelection.addActionListener(new ComboBoxListener());
		
		
		for(JButton btn : updateCreateBtn) {
			btn.addActionListener(new CreateAndUpdateListener());
		}
	}
	
	private class ComboBoxListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			@SuppressWarnings("unchecked")
			JComboBox<String> selection = (JComboBox<String>)e.getSource();
			mongoCollection = (String) selection.getSelectedItem();		
			
		}
		
	}
	
	private class MainMenuListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if(menuBtn == e.getSource()) {
				ps.showCard("ManagerData");
			}		
		}		
	}
	
	private class DataListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(search == e.getSource()) {
				String name = managerDataPanel.getName();
				dc.setCollection(mongoCollection);
				MongoCollection<Document> mc = dc.getCollection();
				Document d = mc.find(eq("name", name)).first();
				try {
					managerDataPanel.updateInfo("Name: "+d.getString("name")+ "\nAddress: " +
							d.getString("address") + "\nID: " + d.getString("ID"));
				} catch(Exception ex) {
					managerDataPanel.updateInfo(name + " does not exist");
				}				
			}
		}
	}
	
	private class CreateAndUpdateListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			checkButton(e.getSource());
		}
		private void checkButton(Object o) {
			String[] info = managerDataPanel.getNewInfo();
			if(mongoCollection.equals("Customers") && info !=null) {
				if(o == updateCreateBtn[0]) {
					customerHandler.addCustomer(info);
				} else if(o == updateCreateBtn[1]) {
					customerHandler.updateCustomer(info);
				}
			}else if(mongoCollection.equals("Employee") && info !=null) {
				/*
				 * TODO Create employeeHandler class with add/update methods
				 */
			} else if(mongoCollection.equals("Products") && info != null){
				/*
				 * TODO Create productHandler class with add/update methods
				 */
			}
		}
	}
}

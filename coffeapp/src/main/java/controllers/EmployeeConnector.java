package controllers;

import gui.CreateCustomerPanel;
import gui.EmployeeMenuPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import database.DatabaseConnector;

public class EmployeeConnector {
	private DatabaseConnector dc;
	private PanelSwitcher ps;
	private EmployeeMenuPanel employee;
	private CreateCustomerPanel createCustomer;
	
	private JButton[] options;
	
	public EmployeeConnector(DatabaseConnector dc, PanelSwitcher ps){
		this.dc = dc;
		this.ps = ps;
		
		employee = (EmployeeMenuPanel)ps.getPanel("EmployeeMenu");
		options = employee.getButtons();
		for(JButton btn : options){
			btn.addActionListener(new OptionListener());
		}
		
		createCustomer = (CreateCustomerPanel)ps.getPanel("CreateCustomer");
	}
	
	private class OptionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			checkButton(e.getSource());
			
		}
		private void checkButton(Object o){
			if(o == options[0]){
				ps.showCard("CreateCustomer");
			}else if(o == options[1]){
				System.out.println("new order clicked");
			}else if(o == options[2]){
				System.out.println("Update clicked");
			}
		}
	}
	
	private class CreateCustomerListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			
		}
		
	}
}

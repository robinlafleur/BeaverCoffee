package controllers;

import javax.swing.JButton;

import database.DatabaseConnector;
import gui.ManagerMenuPanel;

public class ManagerConnector {
	private DatabaseConnector dc;
	private PanelSwitcher ps;
	private ManagerMenuPanel manager;
	
	private JButton[] options;
	
	public ManagerConnector(DatabaseConnector dc, PanelSwitcher ps) {
		this.dc = dc;
		this.ps = ps;
		
		manager = (ManagerMenuPanel)ps.getPanel("ManagerMenu");
	}
}

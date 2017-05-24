package gui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ManagerMenuPanel extends MainMenuPanel{
	private JButton btnEmployeeData = new JButton("Employee data");
	private JButton btnCustomerData = new JButton("Customer data");
	private JButton btnProductData = new JButton("Product data");
	private JButton[] btns = { btnEmployeeData, btnCustomerData, btnProductData };
	public ManagerMenuPanel(int height, int width) {
		super(height, width);
		initManagerMenuGUI();
	}
	
	private void initManagerMenuGUI() {		
		btnEmployeeData.setPreferredSize(new Dimension(120, 20));
		btnCustomerData.setPreferredSize(new Dimension(120, 20));
		btnProductData.setPreferredSize(new Dimension(120, 20));
		
		menuPanel.add(btnEmployeeData);
		menuPanel.add(btnCustomerData);
		menuPanel.add(btnProductData);
	}
	
	public JButton[] getButtons() {
		return btns;
	}
}

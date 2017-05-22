package gui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ManagerMenuPanel extends MainMenuPanel{

	public ManagerMenuPanel(int height, int width) {
		super(height, width);
		initManagerMenuGUI();
	}
	
	private void initManagerMenuGUI() {
		JButton btnEmployeeData = new JButton("Employee data");
		JButton btnCustomerData = new JButton("Customer data");
		JButton btnProductData = new JButton("Product data");
		
		btnEmployeeData.setPreferredSize(new Dimension(120, 20));
		btnCustomerData.setPreferredSize(new Dimension(120, 20));
		btnProductData.setPreferredSize(new Dimension(120, 20));
		
		menuPanel.add(btnEmployeeData);
		menuPanel.add(btnCustomerData);
		menuPanel.add(btnProductData);
	}
	
	//Test
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new ManagerMenuPanel(500, 400));
		frame.pack();
		frame.setVisible(true);
	}

}

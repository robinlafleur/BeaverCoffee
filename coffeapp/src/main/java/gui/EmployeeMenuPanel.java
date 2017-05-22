package gui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class EmployeeMenuPanel extends MainMenuPanel {

	public EmployeeMenuPanel(int height, int width) {
		super(height, width);
		initEmployeeMenuGUI();
	}
	
	private void initEmployeeMenuGUI() {
		JButton btnAddCustomer = new JButton("Add customer");
		JButton btnNewOrder = new JButton("New order");
		JButton btnUpdateOrder = new JButton("Update order");
		btnNewOrder.setPreferredSize(new Dimension(120, 20));
		btnUpdateOrder.setPreferredSize(new Dimension(120, 20));
		btnAddCustomer.setPreferredSize(new Dimension(120, 20));
		menuPanel.add(btnNewOrder);
		menuPanel.add(btnUpdateOrder);
		menuPanel.add(btnAddCustomer);
	}
	
	//Test
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new EmployeeMenuPanel(500, 400));
		frame.pack();
		frame.setVisible(true);
	}

}

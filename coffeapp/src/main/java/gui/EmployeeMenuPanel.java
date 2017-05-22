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
		JButton btnNewOrder = new JButton("New order");
		JButton btnUpdateOrder = new JButton("Update order");
		JButton btnDeleteOrder = new JButton("Delete order");
		JLabel lblMenu = new JLabel("Welcome!", SwingConstants.CENTER);
		btnNewOrder.setPreferredSize(new Dimension(120, 20));
		btnUpdateOrder.setPreferredSize(new Dimension(120, 20));
		btnDeleteOrder.setPreferredSize(new Dimension(120, 20));
		lblMenu.setPreferredSize(new Dimension(80, 100));
		menuPanel.add(lblMenu);
		menuPanel.add(btnNewOrder);
		menuPanel.add(btnUpdateOrder);
		menuPanel.add(btnDeleteOrder);
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

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
		JButton btnOrder = new JButton("New order");
		JLabel lblMenu = new JLabel("Welcome!", SwingConstants.CENTER);
		btnOrder.setPreferredSize(new Dimension(100, 20));
		lblMenu.setPreferredSize(new Dimension(80, 100));
		menuPanel.add(lblMenu);
		menuPanel.add(btnOrder);
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

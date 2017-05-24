package gui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class EmployeeMenuPanel extends MainMenuPanel {
	private JButton btnAddCustomer = new JButton("Add customer");
	private JButton btnNewOrder = new JButton("New order");
	private JButton btnUpdateOrder = new JButton("Update order");

	public EmployeeMenuPanel(int height, int width) {
		super(height, width);
		initEmployeeMenuGUI();
	}
	
	private void initEmployeeMenuGUI() {
		btnNewOrder.setPreferredSize(new Dimension(120, 20));
		btnUpdateOrder.setPreferredSize(new Dimension(120, 20));
		btnAddCustomer.setPreferredSize(new Dimension(120, 20));
		getMenuPanel().add(btnNewOrder);
		getMenuPanel().add(btnUpdateOrder);
		getMenuPanel().add(btnAddCustomer);
	}
	
	public JButton[] getButtons(){
		return new JButton[]{btnAddCustomer, btnNewOrder, btnUpdateOrder};
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

package gui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CustomerDataPanel extends ManagerDataAccessPanel {
	private JTextField tfName = new JTextField("Type customer name here");
	private JTextField tfAddress = new JTextField("Type customer address here");
	private JTextField tfID = new JTextField("Type customer ID,SSN or civic nr here");
	private JButton btnCreate = new JButton("Create");
	private JButton btnUpdate = new JButton("Update");
	private JPanel btnPanel = new JPanel();
	private int width, height;	
	
	public CustomerDataPanel(int height, int width) {
		super(height, width);
		this.width = width;
		this.height = height;
		initCDPanel();
	}
	
	private void initCDPanel() {
		setTopLabel("Customer data");
		Dimension tfSize = new Dimension(width/2, 30);
		Dimension btnSize = new Dimension(120, 30);
		
		tfName.setPreferredSize(tfSize);
		tfAddress.setPreferredSize(tfSize);
		tfID.setPreferredSize(tfSize);
		btnCreate.setPreferredSize(btnSize);
		btnUpdate.setPreferredSize(btnSize);
		btnPanel.setPreferredSize(new Dimension(width, 40));
		
		add(tfName);
		add(tfAddress);
		add(tfID);
		add(btnPanel);
		btnPanel.add(btnCreate);
		btnPanel.add(btnUpdate);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new ProductDataPanel(500, 400));
		frame.pack();
		frame.setVisible(true);
	}

}

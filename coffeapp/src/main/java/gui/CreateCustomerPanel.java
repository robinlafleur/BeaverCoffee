package gui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateCustomerPanel extends JPanel{
	private int width, height;
	
	private JTextField tfName = new JTextField();
	private JTextField tfID = new JTextField();
	private JTextField tfAddress = new JTextField();
	private JTextField tfOccupation = new JTextField();
	
	private JButton btnEnter = new JButton("Add customer");
	
	public CreateCustomerPanel(int width, int height){
		this.width = width;
		this.height = height;
		
		JLabel lblName = new JLabel("Customer name: ");
		JLabel lblID = new JLabel("Customer ID: ");
		JLabel lblAddress = new JLabel("Customer Address: ");
		JLabel lblOccupation = new JLabel("Customer Occupation: ");
		
		lblName.setPreferredSize(new Dimension(130, 50));
		lblID.setPreferredSize(new Dimension(130, 50));
		lblAddress.setPreferredSize(new Dimension(130, 50));
		lblOccupation.setPreferredSize(new Dimension(130, 50));
		
		tfName.setPreferredSize(new Dimension(250, 25));
		tfID.setPreferredSize(new Dimension(250, 25));
		tfAddress.setPreferredSize(new Dimension(250, 25));
		tfOccupation.setPreferredSize(new Dimension(250, 25));
		
		add(lblName);
		add(tfName);
		add(lblID);
		add(tfID);
		add(lblAddress);
		add(tfAddress);
		add(lblOccupation);
		add(tfOccupation);
		
		add(btnEnter);

	}
	
	public JButton getBtnEnter(){
		return btnEnter;
	}
	
	public String[] getTextFieldData(){
		return new String[]{tfName.getText(), tfID.getText(), tfAddress.getText(), tfOccupation.getText()};
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(width, height);
	}
}

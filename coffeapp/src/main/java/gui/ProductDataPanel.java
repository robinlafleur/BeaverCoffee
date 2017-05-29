package gui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProductDataPanel extends ManagerDataAccessPanel {
	private JTextField tfType = new JTextField("Enter product type");
	private JTextField tfName = new JTextField("Enter product name");
	private JTextField tfQuantity = new JTextField("Enter product quantity");
	private JButton btnCreate = new JButton("Create");
	private JButton btnUpdate = new JButton("Update");
	private JPanel btnPanel = new JPanel();
	private int width, height;	
	
	public ProductDataPanel(int height, int width) {
		super(height, width);
		this.width = width;
		this.height = height;
		initPDPanel();
	}
	
	private void initPDPanel() {
		Dimension tfSize = new Dimension(width/2, 30);
		Dimension btnSize = new Dimension(120, 30);
		
		tfName.setPreferredSize(tfSize);
		tfType.setPreferredSize(tfSize);
		tfQuantity.setPreferredSize(tfSize);
		btnCreate.setPreferredSize(btnSize);
		btnUpdate.setPreferredSize(btnSize);
		btnPanel.setPreferredSize(new Dimension(width, 40));
		
		add(tfType);
		add(tfName);
		add(tfQuantity);
		add(btnPanel);
		btnPanel.add(btnCreate);
		btnPanel.add(btnUpdate);
	}

}

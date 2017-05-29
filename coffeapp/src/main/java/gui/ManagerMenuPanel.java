package gui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ManagerMenuPanel extends MainMenuPanel{
	private JButton btnData = new JButton("Get data");

	public ManagerMenuPanel(int height, int width) {
		super(height, width);
		initManagerMenuGUI();
	}
	
	private void initManagerMenuGUI() {		
		btnData.setPreferredSize(new Dimension(120, 20));
		
		getMenuPanel().add(btnData);
	}
	
	public JButton getButton() {
		return btnData;
	}
}

package gui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ManagerDataAccessPanel extends JPanel {
	private JLabel lblTop = new JLabel("Data", SwingConstants.CENTER);
	private JTextField tfSearch = new JTextField("Enter name");
	private JButton btnSearch = new JButton("Search");
	private JTextArea taInfo = new JTextArea("Your information will be displayed here");
	private int height, width;
	
	public ManagerDataAccessPanel(int height, int width) {
		this.height = height;
		this.width = width;
		initMDAPanel();
	}
	
	private void initMDAPanel() {
		setPreferredSize(new Dimension(width, height));
		lblTop.setPreferredSize(new Dimension(width-50, height/8));
		taInfo.setPreferredSize(new Dimension(width, height/3));
		tfSearch.setPreferredSize(new Dimension(width/2, 30));
		btnSearch.setPreferredSize(new Dimension(120, 30));
		taInfo.setLineWrap(true);
		
		add(lblTop);
		add(tfSearch);
		add(btnSearch);
		add(taInfo);
	}

	public void setTopLabel(String name) {
		lblTop.setText(name);
	}
	
	public JButton getButton() {
		return btnSearch;
	}
	
	public String getName() {
		return tfSearch.getText();
	}
	
	public void updateInfo(String info) {
		taInfo.setText(info);
	}
}

package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MainMenuPanel extends JPanel {
	private JPanel menuPanel = new JPanel();
	private JPanel menuLeft = new JPanel();
	private JPanel menuRight = new JPanel();
	private int height, width;
	
	public MainMenuPanel(int height, int width) {
		this.height = height;
		this.width = width;
		initGUI();
	}
	
	private void initGUI() {
		setPreferredSize(new Dimension(height, width));
		setLayout(new GridLayout(0,3));
		JLabel lblMenu = new JLabel("Welcome!", SwingConstants.CENTER);
		add(menuLeft);
		add(menuPanel);
		add(menuRight);
		menuPanel.add(lblMenu);
	}
	
	public JPanel getMenuPanel() {
		return menuPanel;
	}
}

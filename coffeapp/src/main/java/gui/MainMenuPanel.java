package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainMenuPanel extends JPanel {
	JPanel menuPanel = new JPanel();
	JPanel menuLeft = new JPanel();
	JPanel menuRight = new JPanel();
	private int height, width;
	
	public MainMenuPanel(int height, int width) {
		this.height = height;
		this.width = width;
		initGUI();
	}
	
	private void initGUI() {
		setPreferredSize(new Dimension(height, width));
		setLayout(new GridLayout(0,3));
		add(menuLeft);
		add(menuPanel);
		add(menuRight);
	}
	
	//test
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new MainMenuPanel(500, 400));
		frame.pack();
		frame.setVisible(true);
	}
}

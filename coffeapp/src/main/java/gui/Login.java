package gui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @author Robin
 * Login screen for the user
 * 
 */
public class Login extends JPanel{
	private int width, height;
	
	private JPanel panel = new JPanel();
	private JLabel lblLogin = new JLabel("Welcome. Please enter username and password");
	private JLabel lblUsername = new JLabel("Username: ");
	private JLabel lblPassword = new JLabel("Password: ");
	private JTextField tfUsername = new JTextField();
	private JPasswordField pfPassword = new JPasswordField();
	private JButton btnLogin = new JButton("Login");
	
	public Login(int width, int height) {
		this.width = width;
		this.height = height;
		initGUIComponents();
	}
	
	/*
	 * Initializes the gui components
	 */	
	private void initGUIComponents() {
		
		lblLogin.setPreferredSize(new Dimension(300, 100));
		add(lblLogin);
		
		tfUsername.setPreferredSize(new Dimension(200, 25));
		lblUsername.setPreferredSize(new Dimension(100, 40));
		lblPassword.setPreferredSize(new Dimension(100, 40));
		pfPassword.setPreferredSize(new Dimension(200, 25));
		btnLogin.setPreferredSize(new Dimension(100, 25));
		
		panel.add(lblUsername);
		panel.add(tfUsername);
		panel.add(lblPassword);
		panel.add(pfPassword);
		panel.add(btnLogin);
		
		panel.setPreferredSize(new Dimension(400,400));
		add(panel);
		
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(width, height);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new Login(500, 400));
		frame.pack();
		frame.setVisible(true);
	}

}

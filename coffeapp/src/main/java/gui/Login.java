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
	private JPanel panel = new JPanel();
	private JLabel lblLogin = new JLabel("Welcome. Please enter username and password");
	private JLabel lblUsername = new JLabel("Username: ");
	private JLabel lblPassword = new JLabel("Password: ");
	private JTextField tfUsername = new JTextField();
	private JPasswordField pfPassword = new JPasswordField();
	private JButton btnLogin = new JButton();
	
	public Login() {
		initGUIComponents();
	}
	
	/*
	 * Initializes the gui components
	 */	
	private void initGUIComponents() {
//		setPreferredSize(new Dimension(300, 350));
		
		lblLogin.setPreferredSize(new Dimension(300, 100));
		add(lblLogin);
		
		tfUsername.setPreferredSize(new Dimension(200, 30));
		lblUsername.setPreferredSize(new Dimension(100, 40));
		add(lblUsername);
		add(tfUsername);
		
		lblPassword.setPreferredSize(new Dimension(100, 40));
		pfPassword.setPreferredSize(new Dimension(200, 30));
		add(lblPassword);
		add(pfPassword);
		
	}
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new Login());
		frame.setVisible(true);
	}

}

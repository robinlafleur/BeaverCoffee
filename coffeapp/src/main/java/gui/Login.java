package gui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
	private JComboBox<String> cbUser;
	private JLabel lblErrorMsg = new JLabel("");
	
	public Login(int width, int height) {
		this.width = width;
		this.height = height;
		initGUIComponents();
	}
	
	/*
	 * Initializes the gui components
	 */	
	private void initGUIComponents() {
		setPreferredSize(getPreferredSize());
		lblLogin.setPreferredSize(new Dimension((width-200), (height-300)));
		add(lblLogin);
		
		tfUsername.setPreferredSize(new Dimension((width-200), 25));
		lblUsername.setPreferredSize(new Dimension((width-200), 40));
		lblPassword.setPreferredSize(new Dimension((width-200), 40));
		pfPassword.setPreferredSize(new Dimension((width-200), 25));
		btnLogin.setPreferredSize(new Dimension((width-300), 25));
		lblErrorMsg.setPreferredSize(new Dimension(width-300, 25));
		
		String[] strUsers = {"Employee", "Manager", "Employer"};
		cbUser = new JComboBox<String>(strUsers);
		cbUser.setPreferredSize(new Dimension(width-300, 25));
		add(cbUser);
		
		panel.add(lblUsername);
		panel.add(tfUsername);
		panel.add(lblPassword);
		panel.add(pfPassword);
		panel.add(btnLogin);
		panel.add(lblErrorMsg);
		
		panel.setPreferredSize(new Dimension(400,400));
		add(panel);
		
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(width, height);
	}
	
	public String getUsername(){
		return tfUsername.getText();
	}
	
	public String getPassword(){
		String str = new String(pfPassword.getPassword());
		return str;
	}
	
	public JButton getBtnLogin(){
		return btnLogin;
	}
	
	public JComboBox<String> getCbUser(){
		return cbUser;
	}
	
	public void setErrorMsg(String error){
		lblErrorMsg.setText(error);
	}
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new Login(500, 400));
		frame.pack();
		frame.setVisible(true);
	}

}

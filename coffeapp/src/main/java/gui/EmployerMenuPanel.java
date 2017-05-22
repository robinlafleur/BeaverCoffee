package gui;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EmployerMenuPanel extends MainMenuPanel{

	public EmployerMenuPanel(int height, int width) {
		super(height, width);
		initEmployerMenuGUI();
	}
	
	private void initEmployerMenuGUI() {
		JButton btnEmployeeInfo = new JButton("Employee info");
		menuPanel.add(btnEmployeeInfo);
	}
	
	//Test
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new EmployerMenuPanel(500, 400));
		frame.pack();
		frame.setVisible(true);
	}

}

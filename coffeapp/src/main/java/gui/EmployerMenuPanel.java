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
		getMenuPanel().add(btnEmployeeInfo);
	}
	
}

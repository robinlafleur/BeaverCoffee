package gui;

import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EmployeeInfoPanel extends JPanel {
	private DefaultListModel<String> model = new DefaultListModel<String>();
	private JList<String> employeeList = new JList<String>(model);
	private int height, width;
	private JTextArea taComment = new JTextArea();
	private JScrollPane spList = new JScrollPane(employeeList);
	private JScrollPane spComment = new JScrollPane(taComment);
	private JButton btnSubmit = new JButton("Submit comment");
	
	public EmployeeInfoPanel(int height, int width) {
		this.height = height;
		this.width = width;
		initInfoGUI();
	}
	
	private void initInfoGUI() {
		setPreferredSize(new Dimension(width, height));
		spList.setPreferredSize(new Dimension(width/3, height/2));
		spComment.setPreferredSize(new Dimension(width/2, height/2));
		btnSubmit.setPreferredSize(new Dimension(140, 30));
		taComment.setLineWrap(true);
		add(spList);
		add(spComment);
		add(btnSubmit);
	}
}

package gui;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PlacedOrderPanel extends JPanel {
	private int height, width;
	private JButton btnDeleteOrder = new JButton("Delete");
	private JButton btnUpdateOrder = new JButton("Update");
	private JPanel[] panel = new JPanel[3];
	private DefaultListModel<String> model = new DefaultListModel<String>();
	private JList<String> orderList = new JList<String>(model);
	private JScrollPane scrollPane = new JScrollPane(orderList);
	
	public PlacedOrderPanel(int height, int width) {
		this.height = height;
		this.width = width;
		initOrderGUI();
	}
	
	private void initOrderGUI() {
		setLayout(new GridLayout(0,3));
		setPreferredSize(new Dimension(height, width));
		for(int i = 0; i < 3; i++) {
			panel[i] = new JPanel();
			add(panel[i]);
		}
		scrollPane.setPreferredSize(new Dimension(width/3, height/2));
		btnUpdateOrder.setPreferredSize(new Dimension(75, 20));
		btnDeleteOrder.setPreferredSize(new Dimension(75, 20));
		panel[1].add(btnUpdateOrder);
		panel[1].add(btnDeleteOrder);
		panel[1].add(scrollPane);
	}	
}

package com.myapp.app.swingapp;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

public class ViewRegistrations extends JFrame{
	
	private JPanel controlPanel;
	private JTable table;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	
	ViewRegistrations()
	{
		createMenuBar();
		
		DefaultTableModel dm = new JDBCEntries().showAll();
		table.setModel(dm);
				
		setTitle("View Customers");
		setSize(700, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				UpdatePage update = new UpdatePage();
				setVisible(false);
				update.setVisible(true);
			}
		});
				
		JScrollPane scrollPane = new JScrollPane();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JButton delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				int index = table.getSelectedRow();
				String id = table.getValueAt(index, 0).toString();
				
				if(new JDBCEntries().delete(id))
				{
					JOptionPane.showMessageDialog(null, "Successfully Submitted");	
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Not Submitted");
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(194)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 627, GroupLayout.PREFERRED_SIZE)))
					.addGap(28))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(227)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(delete, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
						.addComponent(update, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
					.addGap(237))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(80)
					.addComponent(update)
					.addGap(61)
					.addComponent(delete)
					.addContainerGap(83, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "First Name", "Surname", "Age", "Gender", "Empl./Cust.", "Student", "Mon./Week."
			}
		));
		scrollPane_1.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		
	    
	
}
	
	private void createMenuBar() 
	{
		JMenuBar menu_bar = new JMenuBar();
		
		JMenu options = new JMenu("Options");
		
		JMenuItem back = new JMenuItem("Back");
		back.setMnemonic(KeyEvent.VK_B);
		back.setToolTipText("VGo back to Main Menu");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				MainPage main = new MainPage();
				setVisible(false);
				main.setVisible(true);
			}
		});
		
		options.add(back);
		
		menu_bar.add(options);
		setJMenuBar(menu_bar);
	}
	
	public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            public void run() {
            	ViewRegistrations view = new ViewRegistrations();
                view.setVisible(true);
            }
        });
	}
}

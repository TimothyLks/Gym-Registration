package com.myapp.app.swingapp;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JMenu;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;

public class UpdatePage extends JFrame{

	private JPanel controlPanel;
	private JTextField first_name;
	private JTextField surname;
	private JTextField age;
	private JTable table;
	private JComboBox gender;
	private JCheckBox student;
	private final ButtonGroup empl_cust = new ButtonGroup();
	private final ButtonGroup month_week = new ButtonGroup();
	
	UpdatePage()
	{
		createMenuBar();
		
		DefaultTableModel dm = new JDBCEntries().showAll();
		table.setModel(dm);
				
		setTitle("Update");
		setSize(700, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JButton submit = new JButton("Update");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(new JDBCEntries().update(first_name.getText(), surname.getText(), age.getText(), gender.getSelectedItem().toString(), empl_cust.getSelection().toString(), student.getSelectedIcon().toString(), month_week.getSelection().toString()))
				{
					JOptionPane.showMessageDialog(null, "Successfully Updated");
					ViewRegistrations registrations = new ViewRegistrations();
					setVisible(false);
					registrations.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Not Updated");
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("First Name");
		
		JLabel lblNewLabel_1 = new JLabel("Surname");
		
		JLabel lblNewLabel_2 = new JLabel("Age");
		
		JLabel lblNewLabel_3 = new JLabel("Gender");
		
		first_name = new JTextField();
		first_name.setColumns(10);
		
		surname = new JTextField();
		surname.setColumns(10);
		
		age = new JTextField();
		age.setColumns(10);
		
		String[] combo = {"Male", "Female"};
		gender = new JComboBox(combo);
		
		JRadioButton employee = new JRadioButton("Employee");
		empl_cust.add(employee);
		
		JRadioButton customer = new JRadioButton("Customer");
		empl_cust.add(customer);
		
		student = new JCheckBox("Student");
		
		JRadioButton monthly = new JRadioButton("Monthly Pay");
		month_week.add(monthly);
		
		JRadioButton weekly = new JRadioButton("Weekly Pay");
		month_week.add(weekly);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(194)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 627, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel)
										.addComponent(lblNewLabel_1)
										.addComponent(lblNewLabel_2)
										.addComponent(lblNewLabel_3))
									.addGap(82)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(gender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(first_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(surname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(age, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGap(43)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(student)
												.addGroup(groupLayout.createSequentialGroup()
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(employee)
														.addComponent(customer))
													.addGap(71)
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(weekly)
														.addComponent(monthly)))))))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(226)
							.addComponent(submit, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(first_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(employee)
						.addComponent(monthly))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(surname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(customer)
								.addComponent(weekly))
							.addGap(18)
							.addComponent(student))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(41)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(age, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2))))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(gender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addGap(37)
					.addComponent(submit)
					.addGap(32))
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
                UpdatePage update = new UpdatePage();
                update.setVisible(true);
            }
        });
	}
}

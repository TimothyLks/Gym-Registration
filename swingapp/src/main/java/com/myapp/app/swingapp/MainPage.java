package com.myapp.app.swingapp;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainPage extends JFrame {
	
	public MainPage()
	{
		initGUI();
	}
	
	private void initGUI()
	{
		createMenuBar();
				
		setTitle("MainMenu");
		setSize(1000, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void createMenuBar()
	{		
		JMenuBar menu_bar = new JMenuBar();

		JMenu options = new JMenu("Options");
		
		JMenuItem item1 = new JMenuItem("Register");
		item1.setMnemonic(KeyEvent.VK_R);
		item1.setToolTipText("Register Employee or Customer");
		item1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				Register register = new Register();
				setVisible(false);
				register.setVisible(true);
				
			}
		});
		
		JMenuItem item2 = new JMenuItem("View Registrations");
		item2.setMnemonic(KeyEvent.VK_C);
		item2.setToolTipText("View list of Customers");
		item2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				ViewRegistrations view_registrations = new ViewRegistrations();
			}
		});
		
		JMenuItem item4 = new JMenuItem("Exit");
		item4.setMnemonic(KeyEvent.VK_E);
		item4.setToolTipText("Exit Application");
		item4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				System.exit(0);
			}
		});
		
		options.add(item1);
		options.add(item2);
		options.addSeparator();
		options.add(item4);

		menu_bar.add(options);
		setJMenuBar(menu_bar);
	}
	
	public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            public void run() {
                MainPage main = new MainPage();
                main.setVisible(true);
            }
        });
	}
}

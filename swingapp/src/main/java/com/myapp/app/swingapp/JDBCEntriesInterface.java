package com.myapp.app.swingapp;

import java.util.*;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public interface JDBCEntriesInterface 
{
	public boolean insert(String first_name, String surname, String age, String gender, String empl_cust, String student, String month_week);
	public boolean delete(String id);
	public boolean update(String first_name, String surname, String age, String gender, String empl_cust, String student, String month_week);
	public DefaultTableModel showAll();
}

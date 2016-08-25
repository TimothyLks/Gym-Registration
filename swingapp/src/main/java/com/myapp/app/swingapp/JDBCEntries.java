package com.myapp.app.swingapp;

import javax.sql.*;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

//import org.springframework.jdbc.core.*;

public class JDBCEntries implements JDBCEntriesInterface{

	private DataSource datasource;
	String conString = "jdbc:mysql://localhost:3306/entries";
	String username = "root";
	String password = "";
	
	/*public void setDataSource(DataSource datasource)
	{
		this.datasource = datasource;
	}*/
	
	public boolean insert(String first_name, String surname, String age, String gender, String empl_cust, String student, String month_week) 
	{
		// TODO Auto-generated method stub
		String query = "INSERT INTO ENTRIES(FIRST_NAME, SURNAME, AGE, GENDER, EMPLOYEE_CUSTOMER, STUDENT, MONTHLY_WEEKLY) VALUES(?,?,?,?,?,?,?)";
		Connection conn = null;
		
		
		try
		{
			//conn = datasource.getConnection();
			conn = DriverManager.getConnection(conString, username, password);

			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, first_name);
			System.out.println(first_name);
			ps.setString(2, surname);
			System.out.println(surname);
			ps.setString(3, age);
			System.out.println(age);
			ps.setString(4, gender);
			System.out.println(gender);
			ps.setString(5, empl_cust);
			System.out.println(empl_cust);
			ps.setString(6, student);
			System.out.println(student);
			ps.setString(7, month_week);
			System.out.println(month_week);
			
			ps.executeUpdate();
			
			return true;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(conn != null)
			{
				try
				{
					conn.close();
				}
				catch(SQLException e) {}
			}
		}
		return false;
	}

	public boolean delete(String name) {
		// TODO Auto-generated method stub
		String query = "DELETE FROM ENTRIES = '" + name + "'";
		Connection conn = null;
		
		try
		{
			//conn = datasource.getConnection();
			conn = DriverManager.getConnection(conString, username, password);
			
			Statement s = conn.prepareStatement(query);
			
			s.executeQuery(query);
			
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(conn != null)
			{
				try
				{
					conn.close();
				}
				catch(SQLException e) {}
			}
		}
		return false;
	}

	public boolean update(String first_name, String surname, String age, String gender, String empl_cust, String student, String month_week)
	{
		// TODO Auto-generated method stub
		String query = "UPDATE ENTRIES SET FIRST_NAME = '" + first_name + "', SURNAME = '" + surname + "', AGE = '" + age + "', GENDER = '" + gender + "', EMPLOYEE_CUSTOMER = '" + empl_cust + "', STUDENT = '" + student + "', MONTHLY_WEEKLY = '" + month_week + "'";
		Connection conn = null;
		
		try
		{
			//conn = datasource.getConnection();
			conn = DriverManager.getConnection(conString, username, password);
			
			PreparedStatement s = conn.prepareStatement(query);
			
			s.executeQuery(query);
			
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(conn != null)
			{
				try
				{
					conn.close();
				}
				catch(SQLException e) {}
			}
		}
		return false;
	}

	public DefaultTableModel showAll() {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		
		DefaultTableModel dm = new DefaultTableModel();
		dm.addColumn("First Name");
		dm.addColumn("Surname");
		dm.addColumn("Age");
		dm.addColumn("Gender");
		dm.addColumn("Empl/Cust");
		dm.addColumn("Student");
		dm.addColumn("Month/Week");
		
		String query = "SELECT * FROM ENTRIES";
		
		try
		{
			//conn = datasource.getConnection();
			conn = DriverManager.getConnection(conString, username, password);
			
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery(query);
			
			while(rs.next())
			{
				String id = rs.getString(1);
				String first_name = rs.getString(2);
				String surname = rs.getString(3);
				String age = rs.getString(4);
				String gender = rs.getString(5);
				String empl_cust = rs.getString(6);
				String student = rs.getString(7);
				String month_week = rs.getString(8);
				
				dm.addRow(new String[]{id, first_name, surname, age, gender, empl_cust, student, month_week});
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(conn != null)
			{
				try
				{
					conn.close();
				}
				catch(SQLException e) {}
			}
		}
		
		return null;
	}
}

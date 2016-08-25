package com.myapp.app.swingapp;

import java.sql.*;

import org.springframework.jdbc.core.*;

@SuppressWarnings("rawtypes")
public class DBRowMapper implements RowMapper {

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		return rowNum;
	}	
	
	public Object mapRow2(ResultSet rs, int rowNum) throws SQLException {
		return rowNum;
	}
}

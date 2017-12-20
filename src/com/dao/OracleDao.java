package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class OracleDao {
	Connection connection;
	StringBuffer sql;
	CallableStatement call ;
	int NUM;
	ResultSet rs;
	private void create() throws SQLException{
		 connection = DriverManager
				.getConnection(
						"jdbc:oracle:thin:@115.159.203.74:49161:xe",
						"maven", "maven");
		sql=new StringBuffer("{Call ?(");
	}
	private void close() throws SQLException{
		call.close();
		connection.close();
	}
	private void callExecute(String proName,Object ...params) throws SQLException{
		for (Object object : params) {
			sql.append("?,");
		}
		sql=sql.replace(sql.length()-1, sql.length(),")}");
		call= connection.prepareCall(sql.toString());  
		int NUM=1;
		call.setObject(NUM, proName);  
		NUM++;
		call.registerOutParameter(NUM, Types.INTEGER);  
		for (Object object : params) {
			NUM++;
			call.setObject(NUM, object.toString());  
		}
	}

	public Integer insertOrUpdateOrDelete(String proName,Integer status,Object ...params) throws SQLException{
		create();
		callExecute(proName,status,params);
		call.executeUpdate(); 
		int flag=call.getInt(2);
		close();
		return flag;
	}
	
}

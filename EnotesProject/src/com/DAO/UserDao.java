package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.User.UserDetails;





public class UserDao {
private Connection connection;

public UserDao(Connection connection) {
	super();
	this.connection = connection;
}

public boolean addUserDetails(UserDetails userDetails){
	boolean f=false;
	try {
		if (connection!=null) {
			String queryString="insert into user(firstName,lastName,email,number,password) values(?,?,?,?,?)";
			PreparedStatement pstmt=connection.prepareStatement(queryString);
			if (pstmt!=null) 
			{
				pstmt.setString(1, userDetails.getFirstNameString());
				pstmt.setString(2, userDetails.getLastNameString());
				pstmt.setString(3, userDetails.getEmailString());
				pstmt.setString(4, userDetails.getPhoneString());
				pstmt.setString(5, userDetails.getPasswordString());
				int i=pstmt.executeUpdate();
				if (i==1) {
					f=true;
				}
			}
		}
	} catch (Exception e) {
	e.printStackTrace();
	}
	return f;
	
	
	
	
	}

public UserDetails loginUser(UserDetails us){
	UserDetails user=null;
	try {
		String query="select * from user where email=? and password=?";
		PreparedStatement pstmt=connection.prepareStatement(query);
		pstmt.setString(1, us.getEmailString());
		pstmt.setString(2, us.getPasswordString());
		ResultSet rSet=pstmt.executeQuery();
		
		if (rSet.next()) {
			user=new UserDetails();
			user.setId(rSet.getInt("id"));
			user.setFirstNameString(rSet.getString("firstName"));
			user.setLastNameString(rSet.getString("lastName"));
			user.setEmailString(rSet.getString("email"));
			user.setPhoneString(rSet.getString("number"));
			user.setPasswordString(rSet.getString("password"));
			
			
			
			
			
		}
		
		
	} catch (Exception e) {
e.printStackTrace();
	}
	

	return user;
}
		}


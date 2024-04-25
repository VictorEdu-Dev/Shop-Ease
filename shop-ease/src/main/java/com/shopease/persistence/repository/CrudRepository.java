package com.shopease.database.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shopease.controller.system.users.DefaultUser;
import com.shopease.database.DatabaseConnection;

public class AuthSessionDAO {
	private static final String table = "admin_user_system";
	
	public static boolean subscribeUser(DefaultUser user) {
		
		if(!validateCredencials(user)) {
			try(Connection conn = DatabaseConnection.getConnection();
		             PreparedStatement stmt = conn.prepareStatement("INSERT INTO " + table +" (name, username, email, phone_number, password) VALUES (?, ?, ?, ?, ?)")) {
				stmt.setString(1, user.getName());
				stmt.setString(2, user.getUsername());
				stmt.setString(3, user.getEmail());
				stmt.setString(4, user.getPhoneNumber());
				stmt.setString(5, user.getPassword());
				int succes = stmt.executeUpdate();
				
				if(succes > 0) {
					return true;
				} else {
					return false;
				}
			} catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
		} else {
			return false;
		}
	}
	
	public static boolean validateCredencials(DefaultUser user) {
	     try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM "+ table +" WHERE username = ? AND password = ?")) {
	         stmt.setString(1, user.getUsername());
	         stmt.setString(2, user.getPassword());
	         try (ResultSet rs = stmt.executeQuery()) {
	             return rs.next();
	         }
	     } catch (SQLException e) {
	         e.printStackTrace();
	         return false;
	     }
	 }
}

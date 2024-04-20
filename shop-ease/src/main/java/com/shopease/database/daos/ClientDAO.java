package com.database.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.controller.system.users.client.Client;
import com.controller.system.users.client.UserClientParameter;
import com.database.DatabaseConnection;

import jakarta.servlet.ServletException;

public class ClientDAO {
	public final static String table = " clients ";
	
	 public void addClient(Client client) throws ServletException {
	        String sql = "INSERT INTO" + table + "(" + extractParameter() + ")" + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, client.getName());
	            pstmt.setString(2, client.getEmail());
	            pstmt.setString(3, client.getAddress());
	            pstmt.setString(4, client.getHomeNumber());
	            pstmt.setString(5, client.getBairro());
	            pstmt.setString(6, client.getCity());
	            pstmt.setString(7, client.getState());
	            pstmt.setString(8, client.getCountry());
	            pstmt.setString(9, client.getPhoneNumber());
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	        	throw new ServletException(e);
	        }
	    }

	    public Client getClientById(int productId) throws ServletException {
	        String sql = "SELECT * FROM" + table + "WHERE id = ?";
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setInt(1, productId);
	            try (ResultSet rs = pstmt.executeQuery()) {
	                if (rs.next()) {
	                    Client client = new Client();
	                    client.setEmail(rs.getString("email"));
	                    client.setName(rs.getString("name"));
	               //     client.setCpf(rs.getString("cpf"));
	                    return client;
	                }
	            }
	        } catch (SQLException e) {
	        	throw new ServletException(e);
	        }
	        return null;
	    }

	    public List<Client> getClientList() throws ServletException {
	        List<Client> client = new ArrayList<>();
	        String sql = "SELECT * FROM " + table;
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql);
	             ResultSet rs = pstmt.executeQuery()) {
	            while (rs.next()) {
	               Client clientUnity = new Client();
	       //        clientUnity.setCpf(rs.getString("cpf"));
	               clientUnity.setName(rs.getString("name"));
	               clientUnity.setEmail(rs.getString("email"));
	               client.add(clientUnity);
	            }
	        } catch (SQLException e) {
	        	throw new ServletException(e);
	        }
	        return client;
	    }

	    public void updateProduct(Client client) throws ServletException {
	        String sql = "UPDATE" + table + "SET name = ?, email = ? WHERE name = ?";
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, client.getName());
	            pstmt.setString(2, client.getEmail());
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	        	throw new ServletException(e);
	        }
	    }

	    public void deleteProduct(int clientId) throws ServletException {
	        String sql = "DELETE FROM" + table + "WHERE id = ?";
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setInt(1, clientId);
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	        	throw new ServletException(e);
	        }
	    }

	    private static String extractParameter() {
	    	StringBuilder str = new StringBuilder();
	    	
	    	for (UserClientParameter p : UserClientParameter.values()) {
				str.append(p.getContent());
				str.append(", ");
			}
	    	
	    	str.deleteCharAt(str.lastIndexOf(", ")); // Remove a última ocorrência de ", " (vírgula e espaço em branco)
	    	return str.toString();
	    }
	    
	    public static void main(String...strings) {
	    	ClientDAO.extractParameter();
	    }

	}
package com.database.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.controller.system.stock.Product;
import com.database.DatabaseConnection;

import jakarta.servlet.ServletException;

public class ProductDAO {

    public void addProduct(Product product) throws ServletException {
        String sql = "INSERT INTO productbatch (category, name, price, brand, date_manufacturing, date_expiration, description) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, product.getCategory());
            pstmt.setString(2, product.getName());
            pstmt.setDouble(3, product.getPrice());
            pstmt.setString(4, product.getBrand());
            pstmt.setString(5, product.getManufacturingDate());
            pstmt.setString(6, product.getExpirationDate());
            pstmt.setString(7, product.getDescription());
            pstmt.executeUpdate();
        } catch (SQLException e) {
        	throw new ServletException(e);
        }
    }

    public Product getProductById(String productId) throws ServletException {
        String sql = "SELECT * FROM productbatch WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, productId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getString("id"));
                    product.setCategory(rs.getString("category"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getDouble("price"));
                    return product;
                }
            }
        } catch (SQLException e) {
        	throw new ServletException(e);
        }
        return null;
    }

    public List<Product> getAllProducts() throws ServletException {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM productbatch";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getString("id"));
                product.setCategory(rs.getString("category"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setBrand("brand");
                product.setManufacturingDate("date-manufacturing");
                product.setExpirationDate("date-expiration");
                product.setDescription("description");
                products.add(product);
            }
        } catch (SQLException e) {
        	throw new ServletException(e);
        }
        return products;
    }

    public void updateProduct(Product product) throws ServletException {
        String sql = "UPDATE productbatch SET category = ?, name = ?, price = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, product.getCategory());
            pstmt.setString(2, product.getName());
            pstmt.setDouble(3, product.getPrice());
            pstmt.setInt(4, 2);
            pstmt.executeUpdate();
        } catch (SQLException e) {
        	throw new ServletException(e);
        }
    }

    public void deleteProduct(int productId) throws ServletException {
        String sql = "DELETE FROM productbatch WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, productId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
        	throw new ServletException(e);
        }
    }
}


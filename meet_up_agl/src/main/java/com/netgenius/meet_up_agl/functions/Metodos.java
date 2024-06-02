/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.netgenius.meet_up_agl.functions;

import com.netgenius.meet_up_agl.bd.ConexionMySql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Adrian Peña Carnero
 */
public class Functions {
    
     ConexionMySql cmq = new ConexionMySql();
     
    
    
     
     
      public boolean login(String usuario, String password) {
        Connection conexion = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean isValidUser = false;

        try {
            // Conectar a la base de datos
            conexion = cmq.conectarMySQL();
            
            // Consulta SQL para verificar las credenciales
            String sql = "SELECT COUNT(*) FROM users WHERE username = ? AND password = ?";
            stmt = conexion.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, password);
            
            // Ejecutar la consulta
            rs = stmt.executeQuery();
            
            // Procesar los resultados
            if (rs.next() && rs.getInt(1) > 0) {
                System.out.println("Usuario Encontrado");
                isValidUser = true;
                
            }
        } catch (SQLException e) {
            System.out.println("Usuario no encontrado");
            e.printStackTrace();
        } finally {
            // Cerrar ResultSet, PreparedStatement y Connection
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isValidUser;
    }
    
  public boolean registerUser(String username, String password, String email, String firstName, String lastName, int age, String gender, String bio) {
        Connection conexion = null;
        PreparedStatement stmt = null;

        try {
            conexion = cmq.conectarMySQL();
            String sql = "INSERT INTO users (username, password, email, first_name, last_name, age, gender, bio, profile_picture) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = conexion.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, email);
            stmt.setString(4, firstName);
            stmt.setString(5, lastName);
            stmt.setInt(6, age);
            stmt.setString(7, gender);
            stmt.setString(8, bio);
            stmt.setString(9, null); // profile_picture puede ser nulo

            int rowsAffected = stmt.executeUpdate();
            System.out.println("Insert correct");
            // Si se insertó al menos una fila, el registro fue exitoso
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Fail insert");
            e.printStackTrace();
            return false; // Si ocurre un error durante la inserción, retorna falso
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    
    
    
    
    
    }
    


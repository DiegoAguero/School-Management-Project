package com.db;

import java.sql.*;
import java.util.*;
import com.models.Career;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Connect {
    public Connect(){}
    public Connection getConnection() throws SQLException{
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/escuela", "root", "123456");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
    public Connection setConnection(String url, String user, String password) throws SQLException{
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

    //Añadir objeto carrera
    public void insertCareer(Career career) throws SQLException{
        Connection connection = getConnection();
        String SQLQuery = "INSERT INTO carreras (nombre) VALUES (?)";
        PreparedStatement st = connection.prepareStatement(SQLQuery);
        
        st.setString(1, career.getName());
        int rowsInserted = st.executeUpdate();
        System.out.println("Rows inserted: " + rowsInserted);
        connection.close();
    }
//    public void updateCareer() throws SQLException{
//        Connection connection = getConnection();
//        String SQLQuery = "UPDATE carreras SET nombre";
//        PreparedStatement st = connection.prepareStatement(SQLQuery);
//        st.setString("Waiting for Career's.OBJ", SQLQuery);
//        connection.close();
//    }
//    public void deleteCareer() throws SQLException{
//        Connection connection = getConnection();
//        String SQLQuery = "DELETE FROM carreras (nombre) VALUES ?";
//        PreparedStatement st = connection.prepareStatement(SQLQuery);
//        st.setString("Waiting for Career's.OBJ", SQLQuery);
//        connection.close();
//
//    }

//    //Esto deberia devolver algo
//    public void readCareer() throws SQLException{
//        Connection connection = getConnection();
//        String SQLQuery = "SELECT * FROM carreras";
//        PreparedStatement st = connection.prepareStatement(SQLQuery);
//        st.setString("Waiting for Career's.OBJ", SQLQuery);
//        connection.close();
//
//    }
}
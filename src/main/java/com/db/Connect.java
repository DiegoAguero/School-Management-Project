package com.db;

import java.io.FileInputStream;
import java.io.IOException;
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
            Properties props = new Properties();
            props.load(new FileInputStream("config/db.properties"));
            String URL = props.getProperty("URL");
            String DRIVER = props.getProperty("DRIVER");
            String USER = props.getProperty("USER");
            String PASSWORD = props.getProperty("PASSWORD");
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | IOException ex) {
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

    public void insertCareer(Career career) throws SQLException{
        Connection connection = getConnection();
        String SQLQuery = "INSERT INTO carreras (nombre) VALUES (?)";
        PreparedStatement st = connection.prepareStatement(SQLQuery);
        st.setString(1, career.getName());
        int rowsInserted = st.executeUpdate();
        System.out.println("Rows inserted: " + rowsInserted);
        connection.close();
    }
    public void updateCareer(String oldName, Career career) throws SQLException{
       Connection connection = getConnection();
       String SQLQuery = "UPDATE carreras SET nombre = ? WHERE nombre = ?";
       PreparedStatement st = connection.prepareStatement(SQLQuery);
       st.setString(1, career.getName());
       st.setString(2, oldName);
       int rowsInserted = st.executeUpdate();
       System.out.println("Rows updated: " + rowsInserted);
       connection.close();
    }
    public void deleteCareer(Career career) throws SQLException{
        Connection connection = getConnection();
        String SQLQuery = "DELETE FROM carreras WHERE nombre = ?";
        PreparedStatement st = connection.prepareStatement(SQLQuery);
        st.setString(1, career.getName());
        int careerDeleted = st.executeUpdate();
        System.out.println("Career deleted: " + careerDeleted);
        connection.close();
    }
    public void readCareer() throws SQLException{
        Connection connection = getConnection();
        String SQLQuery = "SELECT * FROM carreras";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(SQLQuery);
        while (rs.next()) {
            String nameOfCareer = rs.getString("nombre");
            System.out.println(nameOfCareer + "\n");
        }
        connection.close();
    }
}
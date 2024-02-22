package main.java.com.db;
import java.sql.*;
import java.util.*;
public class Connect {
    public Connect(){}
    public Connection getConnection() throws SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/bd1", "root", "123456");
        return connection;
    }
    public Connection setConnection(String url, String user, String password) throws SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
    //Añadir objeto carrera
    public void insertCareer(Connection connection) throws SQLException{
        String SQLQuery = "INSERT INTO carreras (nombre) VALUES ?";
        PreparedStatement st = connection.prepareStatement(SQLQuery);
        //Esperar objeto carrera
        st.setString("Carrera.OBJ", SQLQuery);
    }
    public void deleteCareer(Connection connection){
        String SQLQuery = "DELETE FROM carreras (nombre) VALUES ?";
        PreparedStatement st = connection.prepareStatement(SQLQuery);
        st.setString("Waiting for Career's.OBJ", SQLQuery);
    }
    public void updateCareer(Connection connection){
        String SQLQuery = "UPDATE carreras SET nombre";
        PreparedStatement st = connection.prepareStatement(SQLQuery);
        st.setString("Waiting for Career's.OBJ", SQLQuery);

    }
    //Esto deberia devolver algo
    public void readCareer(Connection connection){
        String SQLQuery = "SELECT * FROM carreras";
        PreparedStatement st = connection.prepareStatement(SQLQuery);
        st.setString("Waiting for Career's.OBJ", SQLQuery);

    }
}
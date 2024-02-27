package com.db;

import java.sql.*;
import com.models.Career;
public class CareerQuery{
    public CareerQuery(){}
    public void insertCareer(Career career, Connection stablishConnection) throws SQLException{
        String SQLQuery = "INSERT INTO carreras (nombre) VALUES (?)";
        PreparedStatement st = stablishConnection.prepareStatement(SQLQuery);
        st.setString(1, career.getName());
        int rowsInserted = st.executeUpdate();
        System.out.println("Rows inserted: " + rowsInserted);
    }
    public void updateCareer(String oldName, Career career, Connection stablishConnection) throws SQLException{
       String SQLQuery = "UPDATE carreras SET nombre = ? WHERE nombre = ?";
       PreparedStatement st = stablishConnection.prepareStatement(SQLQuery);
       st.setString(1, career.getName());
       st.setString(2, oldName);
       int rowsInserted = st.executeUpdate();
       System.out.println("Rows updated: " + rowsInserted);
    }
    public void deleteCareer(Career career, Connection stablishConnection) throws SQLException{
        String SQLQuery = "DELETE FROM carreras WHERE nombre = ?";
        PreparedStatement st = stablishConnection.prepareStatement(SQLQuery);
        st.setString(1, career.getName());
        int careerDeleted = st.executeUpdate();
        System.out.println("Career deleted: " + careerDeleted);
    }
    public void readCareer(Connection stablishConnection) throws SQLException{
        String SQLQuery = "SELECT * FROM carreras";
        Statement st = stablishConnection.createStatement();
        ResultSet rs = st.executeQuery(SQLQuery);
        while (rs.next()) {
            String nameOfCareer = rs.getString("nombre");
            System.out.println(nameOfCareer + "\n");
        }
    }
}

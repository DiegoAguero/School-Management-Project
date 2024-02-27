/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.db;

import com.models.Career;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Mati
 */
public class StudentQuery {
    public void insertStudent(Student student) throws SQLException{
        Connection connection = getConnection();
        String SQLQuery = "INSERT INTO alumnos (nombre, apellido, dni) VALUES (?, ?, ?)";
        PreparedStatement st = connection.prepareStatement(SQLQuery);
        st.setString(1, student.getName());
        st.setString(2,student.getLastname());
        st.setString(2,student.getDni());
        int rowsInserted = st.executeUpdate();
        System.out.println("Rows inserted: " + rowsInserted);
        connection.close();
    }
    public void updateStudent(String Dni, Student student) throws SQLException{
       Connection connection = getConnection();
       String SQLQuery = "UPDATE alumnos SET nombre = ?, apellido = ?, dni = ? WHERE dni = ?";
       PreparedStatement st = connection.prepareStatement(SQLQuery);
       st.setString(1, student.getName());
       st.setString(2, student.getLastname());
       st.setString(3, student.getDni());
   
       int rowsInserted = st.executeUpdate();
       System.out.println("Rows updated: " + rowsInserted);
       connection.close();
    }
    /*public void deleteStudent(Student student) throws SQLException{
        Connection connection = getConnection();
        String SQLQuery = "DELETE FROM alumnos WHERE nombre = ?";
        PreparedStatement st = connection.prepareStatement(SQLQuery);
        st.setString(1, student.getName());
        int studentDeleted = st.executeUpdate();
        System.out.println("Student deleted: " + studentDeleted);
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
    }*/
}


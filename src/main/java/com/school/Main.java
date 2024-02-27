package com.school;
import java.util.Scanner;
import com.models.Career;
import com.db.CareerQuery;
import com.db.Connect;

import java.sql.*;
import java.sql.SQLException;
public class Main {
    // private static ArrayList<String> elementos = new ArrayList<>();
    public static void main(String[] args) throws SQLException{
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        Connection connection = Connect.getConnection();
        CareerQuery careerQuery = new CareerQuery();
        while (!salir) {
            System.out.println("1. Añadir carrera");
            System.out.println("2. Actualizar carrera");
            System.out.println("3. Ver carrera");
            System.out.println("4. Borrar carrera");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            
            switch (opcion) {
                case 1:
                try {
                        String name = scanner.nextLine();
                        careerQuery.insertCareer(new Career(name), connection);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    try {
                        System.out.println("Insertar nombre antiguo de la carrera: ");
                        String oldName = scanner.nextLine();
                        System.out.println("Ingrese el nombre nuevo de la carrera: ");
                        String name = scanner.nextLine();
                        careerQuery.updateCareer(oldName, new Career(name), connection);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        careerQuery.readCareer(connection);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                case 4:
                    try {
                        System.out.println("Ingrese el nombre de la carrera que desea eliminar: ");
                        String name = scanner.nextLine();
                        careerQuery.deleteCareer(new Career(name), connection);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    connection.close();
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
        
        System.out.println("¡Hasta luego!");
    }
     
}

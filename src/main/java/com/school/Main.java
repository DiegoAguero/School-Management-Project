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
        boolean out = false;
        boolean out2 = false;
        Connection connection = Connect.getConnection();
        CareerQuery careerQuery = new CareerQuery();
        while (!out) {
            System.out.println("1. Carreras");
            System.out.println("2. Alumnos");
            System.out.println("3. Matricular");
            System.out.println("4. Salir");
            System.out.println("Seleccione una opción: ");
            byte option = scanner.nextByte();
            scanner.nextLine(); // Limpiar el buffer

            switch (option) {
                case 1:
                    while(!out2){
                        System.out.println("1. Añadir carrera");
                        System.out.println("2. Actualizar carrera");
                        System.out.println("3. Ver carrera");
                        System.out.println("4. Borrar carrera");
                        System.out.println("5. Ver alumnos de una carrera");
                        System.out.println("6. Salir");
                        System.out.print("Seleccione una opción: ");
                        int careerOption = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer
                        switch (careerOption) {
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
                                try {
                                    System.out.println("Ingrese el nombre de la carrera que desea ver los alumnos: ");
                                    String career = scanner.nextLine();
                                    careerQuery.seeStudentsFromCareer(new Career(career), connection);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            case 6:
                                connection.close();
                                out2 = true;
                                break;
                            default:
                                System.out.println("Opción no válida");
                        }
                        break;
                    }
                    break;
                case 2:
                    //Student
                    break;
                case 3: 
                    //Enrol student 
                    break;
                case 4:
                    connection.close();
                    out = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }

            

        }
        scanner.close();
        System.out.println("¡Hasta luego!");
    }
     
}

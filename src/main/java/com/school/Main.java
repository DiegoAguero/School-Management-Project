package com.school;
import java.util.ArrayList;
import java.util.Scanner;
import com.models.Career;
import com.db.Connect;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Main {
    // private static ArrayList<String> elementos = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        Connect connection = new Connect();
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
                        connection.insertCareer(new Career(name));
                    } catch (SQLException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;

                case 2:
                try {
                        System.out.println("Insertar nombre antiguo de la carrera: ");
                        String oldName = scanner.nextLine();
                        System.out.println("Ingrese el nombre nuevo de la carrera: ");
                        String name = scanner.nextLine();
                        connection.updateCareer(oldName, new Career(name));
                    } catch (SQLException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
        
        System.out.println("¡Hasta luego!");
    }
     
}

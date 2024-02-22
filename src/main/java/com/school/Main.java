package com.school;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<String> elementos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;
        
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
                    
                    break;
                case 2:
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

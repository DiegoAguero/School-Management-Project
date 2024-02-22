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
                    añadirElemento();
                    break;
                case 2:
                    actualizarElemento();
                    break;
                case 3:
                    verElementos();
                    break;
                case 4:
                    borrarElemento();
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

    private static void añadirElemento() {
        System.out.print("Ingrese el elemento a añadir: ");
        String elemento = scanner.nextLine();
        elementos.add(elemento);
        System.out.println("Elemento añadido correctamente.");
    }

    private static void actualizarElemento() {
        verElementos();
        System.out.print("Ingrese el índice del elemento a actualizar: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        if (indice >= 0 && indice < elementos.size()) {
            System.out.print("Ingrese el nuevo valor del elemento: ");
            String nuevoElemento = scanner.nextLine();
            elementos.set(indice, nuevoElemento);
            System.out.println("Elemento actualizado correctamente.");
        } else {
            System.out.println("Índice fuera de rango.");
        }
    }

    private static void verElementos() {
        if (elementos.isEmpty()) {
            System.out.println("La lista está vacía.");
        } else {
            System.out.println("Elementos:");
            for (int i = 0; i < elementos.size(); i++) {
                System.out.println(i + ". " + elementos.get(i));
            }
        }
    }

    private static void borrarElemento() {
        verElementos();
        System.out.print("Ingrese el índice del elemento a borrar: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        if (indice >= 0 && indice < elementos.size()) {
            elementos.remove(indice);
            System.out.println("Elemento borrado correctamente.");
        } else {
            System.out.println("Índice fuera de rango.");
        }
    }
}

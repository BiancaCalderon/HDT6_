import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Menú
        System.out.println("Seleccione la implementación de Map a utilizar:");
        System.out.println("1) HashMap");
        System.out.println("2) TreeMap");
        System.out.println("3) LinkedHashMap");

        int opcion = scanner.nextInt();
        Map<String, Producto> map = MapFactory.getMap(opcion);

        // Leer el archivo
        try (BufferedReader br = new BufferedReader(new FileReader(new File("inventario.txt")))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("\\|");
                String categoria = datos[0];
                String nombre = datos[1];
                int cantidad = Integer.parseInt(datos[2]);
                Producto producto = new Producto(nombre, categoria, cantidad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Inventario inventario = new Inventario(map);

        // opciones
        int opcionMenu;
        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("1) Agregar un producto a la colección");
            System.out.println("2) Mostrar la categoría de un producto");
            System.out.println("3) Mostrar los datos de la colección");
            System.out.println("4) Mostrar los datos de la colección ordenados por tipo");
            System.out.println("5) Mostrar el inventario completo");
            System.out.println("6) Mostrar el inventario ordenado por tipo");
            System.out.println("0) Salir");
            opcionMenu = scanner.nextInt();
            switch (opcionMenu) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (opcionMenu != 0);

        scanner.close();
    }
}

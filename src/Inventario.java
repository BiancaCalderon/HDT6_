import java.util.Map;
import java.util.Scanner;


public class Inventario {

    private static Map<String, Integer> inventario;

    private static void agregarProducto(Map<String, Integer> coleccion) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la categoría del producto que desea agregar: ");
        String categoria = scanner.nextLine();
        if (!inventario.containsKey(categoria)) {
            System.out.println("Categoría inválida");
            return;
        }
        System.out.println("Ingrese la cantidad del producto que desea agregar: ");
        int cantidad = scanner.nextInt();
        coleccion.put(categoria, coleccion.getOrDefault(categoria, 0) + cantidad);
        System.out.println("Producto agregado con éxito");
        agregarProducto(coleccion); // Si desea agregar más productos de la misma categoría
    }

}

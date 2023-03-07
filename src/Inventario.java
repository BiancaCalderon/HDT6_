import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventario {

    private Map<String, Producto> map;
    private Scanner scanner;

    public Inventario(Map<String, Producto> map) {
        this.map = map;
        this.scanner = new Scanner(System.in);
    }

    public void agregarProducto() {
        System.out.println("Ingrese la categoría del producto:");
        String categoria = scanner.next();
        if (!map.containsKey(categoria)) {
            System.out.println("Categoría inválida");
            return;
        }
        System.out.println("Ingrese el nombre del producto:");
        String nombre = scanner.next();
        if (map.containsKey(nombre)) {
            Producto producto = map.get(nombre);
            System.out.println("Ingrese la cantidad a agregar:");
            int cantidad = scanner.nextInt();
            producto.setCantidad(producto.getCantidad() + cantidad);
            System.out.println("Producto agregado");
        } else {
            System.out.println("Ingrese la cantidad:");
            int cantidad = scanner.nextInt();
            Producto producto = new Producto(nombre, categoria, cantidad);
            map.put(nombre, producto);
            System.out.println("Producto agregado");
        }
    }
    public void mostrarCategoria() {
        System.out.println("Ingrese el nombre del producto:");
        String nombre = scanner.next();
        if (!map.containsKey(nombre)) {
            System.out.println("Producto no encontrado");
        } else {
            Producto producto = map.get(nombre);
            System.out.printf("Categoría: %s\n", producto.getCategoria());
        }
    }

    public void mostrarDatos() {
        System.out.printf("\n", "Producto", "Categoría", "Cantidad");
        for (Producto producto : map.values()) {
            System.out.println(producto);
        }
    }

    public void mostrarDatosOrdenados() {
        System.out.printf("\n", "Producto", "Categoría", "Cantidad");
        Map<String, Producto> mapOrdenado = MapFactory.getMap(1);
        mapOrdenado.putAll(map);
        for (Producto producto : mapOrdenado.values()) {
            System.out.println(producto.toString());
        }
    }

    public void mostrarInventario() {
        System.out.printf("\n", "Producto", "Categoría");
        for (Map.Entry<String, Producto> entry : map.entrySet()) {
            System.out.printf("\n", entry.getKey(), entry.getValue().getCategoria());
        }
    }

    public void mostrarInventarioOrdenado() {
        System.out.printf("\n", "Producto", "Categoría");
        Map<String, String> mapOrdenado = new HashMap<>();
        for (Map.Entry<String, Producto> entry : map.entrySet()) {
            mapOrdenado.put(entry.getKey(), entry.getValue().getCategoria());
        }
        for (Map.Entry<String, String> entry : mapOrdenado.entrySet()) {
            System.out.printf("\n", entry.getKey(), entry.getValue());
        }
    }
}

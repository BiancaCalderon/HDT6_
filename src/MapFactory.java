import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.TreeMap;


public class MapFactory {

    public static Map<String, Producto> getMap(int opcion) {
        switch (opcion) {
            case 1:
                return new HashMap<>();
            case 2:
                return new TreeMap<>();
            case 3:
                return new LinkedHashMap<>();
            default:
                throw new IllegalArgumentException("Opción inválida");
        }
    }
}

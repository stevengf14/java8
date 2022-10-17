package ec.com.learning.java8.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 *
 * @author Steven Guamán - October 2022
 */
public class Main {

    private Map<Integer, String> map;

    public void fill() {
        map = new HashMap<>();
        map.put(1, "Steven");
        map.put(2, "Andres");
        map.put(3, "German");
        map.put(4, "Gregorio");
    }

    public void print_v7() {
        for (Entry<Integer, String> e : map.entrySet()) {
            System.out.println("Key: " + e.getKey() + " Value: " + e.getValue());
        }
    }

    public void print_v8() {
        // map.forEach((k, v) -> System.out.println("Key: " + k + " Value: " + v));
        // map.entrySet().stream().forEach(x -> System.out.println(x));
        map.entrySet().stream().forEach(System.out::println);

    }

    public void recolect() {
        Map<Integer, String> recolectedMap = map.entrySet().stream()
                .filter(e -> e.getValue().contains("G"))
                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
        recolectedMap.entrySet().stream().forEach(System.out::println);
    }

    public void putIfAbsent() {
        map.putIfAbsent(4, "Jose");
        map.putIfAbsent(5, "Jaime");
    }

    public void computeIfPresent() {
        map.computeIfPresent(3, (k, v) -> k + v);
        System.out.println(map.get(3));
    }

    public void getOrDefault() {
        String value = map.getOrDefault(6, "Default value");
        System.out.println(value);
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.fill();
        // app.print_v7();
        app.putIfAbsent();
        app.print_v8();
        app.computeIfPresent();
        app.getOrDefault();
        app.recolect();
    }
    
}

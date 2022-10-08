package ec.com.learning.java8.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Steven Guamán - October 2022
 */
public class Main {

    private List<String> list;

    public void fillList() {
        list = new ArrayList<>();
        list.add("Steven");
        list.add("Andres");
        list.add("German");
        list.add("Esteban");
        list.add("Gregorio");
    }

    public void useForEach() {
        // Traditional
        /*for (String element : list) {
            System.out.println(element);
        }*/

        // Lambda
        /*list.forEach(x -> System.out.println(x));*/
        // Method references
        list.forEach(System.out::println);
    }

    public void useRemoveIf() {
        // Java <= 7
        // You can't do this
        /*for (String element : list) {
            if (element.equalsIgnoreCase("Steven")) {
                list.remove(element);
            }
        }*/

        // To solve, we can do this
        /*Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equalsIgnoreCase("Steven")) {
                iterator.remove();
            }
        }*/
        
        // Java 8
        list.removeIf(x -> x.equalsIgnoreCase("Steven"));
        

    }

    public void useSort() {
        list.sort((x,y) -> x.compareTo(y));
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.fillList();
        app.useRemoveIf();
        app.useSort();
        app.useForEach();
    }

}

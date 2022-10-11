package ec.com.learning.java8.stream;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Steven Guamán - October 2022
 */
public class Main {

    private List<String> list;
    private List<String> numbers;

    public Main() {
        list = new ArrayList<>();
        list.add("Steven");
        list.add("Andres");
        list.add("German");
        list.add("Greogorio");

        numbers = new ArrayList<>();
        numbers.add("1");
        numbers.add("2");
        numbers.add("3");
        numbers.add("4");
    }

    public void filter() {
        // Filter by startst with M
        list.stream().filter(x -> x.startsWith("G")).forEach(System.out::println);
    }

    public void sort() {
        // list.stream().sorted().forEach(System.out::println);
        // desc
        list.stream().sorted((x, y) -> y.compareTo(x)).forEach(System.out::println);
    }

    public void transform() {
        list.stream().map(String::toUpperCase).forEach(System.out::println);

        // transform numbers
        // Tradicional 
        /*for(String x: numbers){
            int num = Integer.parseInt(x)+1;
            System.out.println(num);
        }*/
        // java 8
        //numbers.stream().map(Integer::parseInt).forEach(System.out::println);
        numbers.stream().map(x -> Integer.parseInt(x) + 1).forEach(System.out::println);
    }

    public void limit() {
        list.stream().limit(2).forEach(System.out::println);
        numbers.stream().limit(3).forEach(System.out::println);
    }

    public void count() {
        long x = list.stream().count();
        System.out.println("List list: " + x);

        long y = numbers.stream().count();
        System.out.println("List numbers: " + x);
    }

    public static void main(String[] args) {
        Main app = new Main();
        System.out.println("------------Filter------------");
        app.filter();
        System.out.println("------------Sort------------");
        app.sort();
        System.out.println("------------Transform------------");
        app.transform();
        System.out.println("------------Limit------------");
        app.limit();
        System.out.println("------------Count------------");
        app.count();
    }

}

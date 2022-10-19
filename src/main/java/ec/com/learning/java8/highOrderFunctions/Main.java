package ec.com.learning.java8.highOrderFunctions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 * @author Steven Guamán - October 2022
 */
public class Main {

    private Function<String, String> toUpperCase = x -> x.toUpperCase();
    private Function<String, String> toLowerCase = x -> x.toLowerCase();

    public void print(Function<String, String> function, String value) {
        System.out.println(function.apply(value));
    }

    public Function<String, String> show(String message) {
        return (String x) -> message + x;
    }

    public void filter(List<String> list, Consumer<String> consumer, int length, String str) {
        // list.stream().filter(this.setFilterLogic(length)).forEach(consumer);
        list.stream().filter(this.setFilterLogic(str)).forEach(consumer);
    }

    public Predicate<String> setFilterLogic(int length) {
        return text -> text.length() < length;
    }

    public Predicate<String> setFilterLogic(String str) {
        return text -> text.contains(str);
    }

    public static void main(String[] args) {
        Main app = new Main();
        String str = "This is a Test";
        app.print(app.toUpperCase, str);
        app.print(app.toLowerCase, str);

        String answer = app.show("Hi ").apply(str);
        System.out.println(answer);

        List<String> list = new ArrayList<>();
        list.add("Steven");
        list.add("German");
        list.add("Andres");
        list.add("Gregorio");
        // app.filter(list, System.out::println, 4, null);
        app.filter(list, System.out::println, 0, "n");
    }

}

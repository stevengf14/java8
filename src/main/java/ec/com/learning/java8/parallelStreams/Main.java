package ec.com.learning.java8.parallelStreams;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Steven Guamán - October 2022
 */
public class Main {

    private List<Integer> numbers;

    public void fill() {
        numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
    }
    
    public void testStream(){
        numbers.stream().forEach(System.out::println);
    }
    
    public void testParallel(){
        // uising threads
        numbers.parallelStream().forEach(System.out::println);
    }
    
    public static void main(String[] args){
        Main app = new Main();
        app.fill();
        // app.testStream();
        app.testParallel();
    }
}

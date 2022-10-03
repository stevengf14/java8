package ec.com.learning.java8.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Steven Guamán - September 2022
 */
public class LambdaApp {

    public void sort() {
        List<String> list = new ArrayList<>();
        list.add("Steven");
        list.add("Andres");
        list.add("Nicole");
        list.add("Abigail");

        // JDK < 1.8
        /*Collections.sort(list, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });*/
        // JDK >= 1.8 -> lambda
        Collections.sort(list, (String p1, String p2) -> p1.compareTo(p2));
        for (String element : list) {
            System.out.println(element);
        }
    }

    public void calculate() {
        
        // JDK < 1.8
        /*IOperation operation = new IOperation() {
            @Override
            public double average(double num1, double num2) {
                return (num1 + num2) / 2;
            }
        };

        System.out.println(operation.average(2, 3));*/
        
        // JDK >= 1.8 -> lambda
        //IOperation operation = (double num1, double num2) -> (num1+num2)/2;
        IOperation operation = (num1, num2) -> (num1+num2)/2;
        System.out.println(operation.calculate(2, 3));
    }

    public static void main(String[] args) {
        LambdaApp app = new LambdaApp();
        app.sort();
        app.calculate();
    }

}

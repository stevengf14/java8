package ec.com.learning.java8.optional;

import java.util.Optional;

/**
 *
 * @author Steven Guamán - October 2022
 */
public class OptionalApp {
    
    public void test(String value) {
        //System.out.println(value.contains("test"));
        try {
            Optional<String> op = Optional.empty();
            op.get();
        } catch (Exception e) {
            System.out.println("Optional without element");
        }
        
    }
    
    public void orElse(String value) {
        // Normal initialization
        // Optional<String> op = Optional.of(value);
        // Null values
        Optional<String> op = Optional.ofNullable(value);
        String x = op.orElse("predetermined");
        System.out.println(x);
    }
    
    public void orElseThrow(String value) {
        Optional<String> op = Optional.ofNullable(value);
        op.orElseThrow(NumberFormatException::new);
    }
    
    public void isPresent(String value) {
        Optional<String> op = Optional.ofNullable(value);
        System.out.println(op.isPresent());
    }
    
    public static void main(String[] args) {
        OptionalApp app = new OptionalApp();
        app.test(null);
        // app.orElse("test orElse");
        app.orElse(null);
        // app.orElseThrow(null);
        app.orElseThrow("test orElseThrow");
        //app.isPresent("test isPresent");
        app.isPresent(null);
    }
}

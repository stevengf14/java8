package ec.com.learning.java8.lambda.defaultMethod;

/**
 *
 * @author Steven Guamán - October 2022
 */
public interface IPersonB {

    default public void talk() {
        System.out.println("Talking from Person B...");
    }
    
}

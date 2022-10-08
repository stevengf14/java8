package ec.com.learning.java8.defaultMethod;

/**
 *
 * @author Steven Guamán - October 2022
 */
public interface IPersonA {

    public void walk();
    
    default public void talk(){
        System.out.println("Talking from Person A...");
    }

}

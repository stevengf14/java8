package ec.com.learning.java8.lambda.defaultMethod;

/**
 *
 * @author Steven Guamán - October 2022
 */
public class DefaultMethod implements IPersonA, IPersonB{

    @Override
    public void walk() {
        System.out.println("Walking...");
    }
    
    @Override 
    public void talk() {
        //IPersonB.super.talk();
        System.out.println("Talking from main...");
    }
    
    public static void main(String[] args) {
        DefaultMethod app = new DefaultMethod();
        //app.walk();
        app.talk();
    }
    
}

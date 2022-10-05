package ec.com.learning.java8.lambda.functionalInterfaces;

/**
 *
 * @author Steven Guamán - October 2022
 */
// Functional interface is an Interface with unique operation
@FunctionalInterface
public interface IOperation {

    double calculate(double n1, double n2);
    // int calculateInt(); // -> this is not correct

}

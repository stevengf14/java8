package ec.com.learning.java8.methodReferences;

/**
 *
 * @author Steven Guamán - October 2022
 */
@FunctionalInterface
public interface IPerson {

    Person create(int id, String name);

}

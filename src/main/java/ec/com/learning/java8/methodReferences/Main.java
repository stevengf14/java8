package ec.com.learning.java8.methodReferences;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author Steven Guamán - October 2022
 */
public class Main {

    public static void referenceStaticMethod() {
        System.out.println("Reference Static Method");
    }

    public void referenceMethodInstanceObjectArbitrary() {
        String[] names = {"Steven", "Andres", "German"};

        // Tradicional 
        /*Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });*/
        // Using lambda
        /*Arrays.sort(names, (s1, s2) -> s1.compareTo(s2));
        System.out.println(Arrays.toString(names));*/
        // Method references
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));

    }

    public void referenceMethodInstanceObjectParticular() {
        System.out.println("Reference method: Instance of particular object");
    }

    public void referenceConstructor() {

        // Traditional
        /*IPerson iper = new IPerson() {
            @Override
            public Person create(int id, String name) {
                return new Person(id, name);
            }
        };
        Person person = iper.create(1, "Steven");*/
        
        // Using lamda
        /*IPerson iper2 = (x, y) -> (new Person(x, y));
        Person person2 = iper2.create(1, "Steven");
        System.out.println(person2);*/

        // Reference methods
        IPerson iper3 = Person::new;
        Person person3 = iper3.create(1, "Steven");
        System.out.println(person3);
    }

    public void operate() {
        IOperation op = () -> Main.referenceStaticMethod();
        op.hello();

        IOperation op2 = Main::referenceStaticMethod;
        op2.hello();
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.operate();
        app.referenceMethodInstanceObjectArbitrary();

        IOperation op = app::referenceMethodInstanceObjectParticular;
        op.hello();

        app.referenceConstructor();
    }

}

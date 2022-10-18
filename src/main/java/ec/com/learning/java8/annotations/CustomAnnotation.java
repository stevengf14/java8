package ec.com.learning.java8.annotations;

/**
 *
 * @author Steven Guamán - October 2022
 */
public @interface CustomAnnotation {
    
    String name();
    boolean enabled() default true;
    
}

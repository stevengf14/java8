package ec.com.learning.java8.annotations;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 * @author Steven Guamán - October 2022
 */
public class Main {

    @Retention(RetentionPolicy.RUNTIME)
    public @interface Languages {

        Language[] value() default {};
        
    }

    @Repeatable(value = Languages.class)
    public @interface Language {

        String value();
        String userName() default "Steven";
        
    }

    // java 1.7
    /* @Languages({
        @Language("Java"),
        @Language("Python")
    })*/
    // java 1.8
    @Language("Java")
    @Language("Python")
    public interface ProgrammingLanguage {

    }

    public static void main(String[] args) {
        Language[] languageArray = ProgrammingLanguage.class.getAnnotationsByType(Language.class);
        System.out.println("We have: " + languageArray.length + " annotations in Language");
        Languages lan = ProgrammingLanguage.class.getAnnotation(Languages.class);
        for (Language element : lan.value()) {
            System.out.println(element.value());
        }
    }
}

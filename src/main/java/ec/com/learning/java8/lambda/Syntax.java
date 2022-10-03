package ec.com.learning.java8.lambda;

/**
 *
 * @author Steven Guamán - September 2022
 */
public class Syntax {

    public double testSyntax() {
        IOperation operation = (double x, double y) -> (x + y)/2;
        //IOperation operation = (double x, double y) -> {return (x + y) / 2;};
        /*IOperation operation = (double x, double y) -> {
            double a = 2.0;
            System.out.println(a);
            return (x + y) / a;
        };*/
        //IOperation operation = (x, y) -> (x + y) / 2;
        //IOperation operation = () -> 2;
        /*IOperation operation = () -> {
            int x = 2;
            int y = 3;
            return (x + y)/2;
        };*/
        return operation.calculate(2, 3);
    }

    public static void main(String[] args) {
        Syntax app = new Syntax();
        System.out.println(app.testSyntax());
    }
}

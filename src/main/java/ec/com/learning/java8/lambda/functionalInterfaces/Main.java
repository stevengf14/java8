package ec.com.learning.java8.lambda.functionalInterfaces;

/**
 *
 * @author Steven Guamán - October 2022
 */
public class Main {

    public double operate(double x, double y) {
        IOperation op = (n1, n2) -> n1 + n2;
        return op.calculate(x, y);
    }

    public static void main(String[] args) {
        Main app = new Main();
        double rpta = app.operate(2, 3);
        System.out.println(rpta);
    }

}

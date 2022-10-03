package ec.com.learning.java8.lambda;

/**
 *
 * @author Steven Guamán - October 2022
 */
public class Scopes {

    /*
    In short, lambdas have the same variable scope as innerclasses, which are:
    READ ONLY: for local variables
    WRITE/READ: for global variables or class attributes whether static or not.
     */
    private static double attribute1;
    private double attribute2;

    public double testLocalVariable() {
        /* if you dont asign a local variable as final, 
           it will act like one inside a lambda */

        // final double num3 = 3;
        double num3 = 3;
        IOperation operation = new IOperation() {
            @Override
            public double calculate(double num1, double num2) {
                return num1 + num2 + num3;
            }

        };
        IOperation operation2 = (x, y) -> {
            return x + y + num3;
        };
        return operation.calculate(1, 1);
    }

    public double testAtributesStaticVariables() {
        IOperation operation = new IOperation() {
            @Override
            public double calculate(double num1, double num2) {
                attribute1 = num1 + num2;
                attribute2 = attribute1;
                return attribute2;
            }
        };

        IOperation operation2 = (x, y) -> {
            attribute1 = x + y;
            return attribute1;
        };

        return operation.calculate(3, 2);
    }

    public static void main(String[] args) {
        Scopes app = new Scopes();
        System.out.println(app.testLocalVariable());
        System.out.println(app.testAtributesStaticVariables());
    }

}

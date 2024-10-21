package utilidades.funciones;

public class Func3 implements MathFunction {
    @Override
    public double evaluate(double[] variables) {
        double x = variables[0];
        double y = variables[1];

        double denominator = x + y;
        double power = Math.pow(x, 2) + Math.pow(y, 2);

        double result = Math.sqrt(power) / denominator;
        return Math.max(result, 1e-6); // Asegura que el valor sea positivo
    }

    @Override
    public String toString() {
        return "f(x, y) = sqrt(x^2 + y^2) / (x + y)";
    }
}

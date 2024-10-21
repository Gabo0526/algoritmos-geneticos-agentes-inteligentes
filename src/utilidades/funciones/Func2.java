package utilidades.funciones;

public class Func2 implements MathFunction{
    @Override
    public double evaluate(double[] variables) {
        double x = variables[0];
        double y = variables[1];

        if (x + y >= 0) {
            double result = Math.pow(Math.log10(x + y), 2);
            return Math.max(result, 1e-6); // Asegura que el valor sea positivo
        } else {
            return 1e-6; // Retorna un valor positivo pequeño para evitar problemas
        }
    }

    @Override
    public String toString() {
        return "f(x, y) = (log(x + y))^2";
    }
}

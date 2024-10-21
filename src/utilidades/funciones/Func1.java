package utilidades.funciones;

import utilidades.ShowChromosome;

public class Func1 implements MathFunction{
    @Override
    public double evaluate(double[] variables) {
        double x = variables[0];

        return (1 / (1 + Math.pow(Math.E, -x)));
    }

    @Override
    public String toString() {
        return "f(x) = 1 / (1 + e^(-x))";
    }
}

package utilidades.funciones;

import java.io.Serializable;

public interface MathFunction extends Serializable {
    double evaluate(double[] variables);
}

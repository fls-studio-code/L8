package lectia8.homework;

/**
 * Tema pentru acasă (lecția 8): logica calculatorului, separată de interfață.
 * Avantaj: o putem testa cu JUnit (CalculatorLogicTest) fără să deschidem fereastra.
 */
public class CalculatorLogic {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            // cu double, 5 / 0 nu dă eroare, ci Infinity — de aceea verificăm noi
            throw new ArithmeticException("Împărțire la zero");
        }
        return a / b;
    }

    /** Operația complexă la alegere: ridicarea la putere, a^b. */
    public double power(double a, double b) {
        return Math.pow(a, b);
    }

    /** Transformă textul din câmp în număr; acceptă și virgula ("2,5"). */
    public double parse(String text) {
        return Double.parseDouble(text.trim().replace(',', '.'));
    }

    /** Afișează 4.0 ca "4", dar 2.5 rămâne "2.5". */
    public String format(double value) {
        if (value == Math.rint(value) && !Double.isInfinite(value)) {
            return String.valueOf((long) value);
        }
        return String.valueOf(value);
    }
}

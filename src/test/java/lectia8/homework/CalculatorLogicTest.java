package lectia8.homework;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testele pentru tema calculatorului: legătura dintre cele două părți ale lecției.
 * Logica e separată de Swing, deci o putem verifica automat.
 */
public class CalculatorLogicTest {

    CalculatorLogic calc = new CalculatorLogic();

    @Test
    public void add() {
        assertEquals(15, calc.add(7, 8));
        assertEquals(-8, calc.add(-3, -5));          // numere negative: caz de la margine
    }

    @Test
    public void subtract() {
        assertEquals(-1, calc.subtract(2, 3));
    }

    @Test
    public void multiply() {
        assertEquals(0, calc.multiply(123, 0));
        assertEquals(6.25, calc.multiply(2.5, 2.5));
    }

    @Test
    public void divide() {
        assertEquals(2.5, calc.divide(5, 2));
    }

    @Test
    @DisplayName("Împărțirea la zero aruncă excepție")
    public void divideByZero() {
        assertThrows(ArithmeticException.class, () -> calc.divide(5, 0));
    }

    @Test
    public void power() {
        assertEquals(1024, calc.power(2, 10));
        assertEquals(1, calc.power(7, 0));
    }

    @Test
    public void parseAcceptsComma() {
        assertEquals(2.5, calc.parse("2,5"));
        assertEquals(3, calc.parse(" 3 "));
    }

    @Test
    public void parseRejectsLetters() {
        assertThrows(NumberFormatException.class, () -> calc.parse("abc"));
    }

    @Test
    public void formatWholeNumbers() {
        assertEquals("4", calc.format(4.0));
        assertEquals("2.5", calc.format(2.5));
    }

    @Test
    public void appShowsErrorsInsteadOfCrashing() {
        assertEquals("Rezultat: 15", CalculatorApp.calculate("7", "8", "+"));
        assertEquals("Introduceți două numere", CalculatorApp.calculate("7", "x", "+"));
        assertEquals("Nu se poate împărți la zero", CalculatorApp.calculate("7", "0", "÷"));
    }
}

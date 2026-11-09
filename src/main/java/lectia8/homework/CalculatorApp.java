package lectia8.homework;

import java.awt.event.*;
import javax.swing.*;

/**
 * Tema pentru acasă (lecția 8): calculator cu adunare, scădere, înmulțire, împărțire
 * și o operație complexă (putere). Erorile se afișează în fereastră, nu în consolă.
 */
public class CalculatorApp {

    private static final CalculatorLogic logic = new CalculatorLogic();

    public static void main(String[] args) {
        JFrame f = new JFrame("Calculator");

        final JTextField firstNumber = new JTextField();
        final JTextField secondNumber = new JTextField();
        final JLabel answer = new JLabel("Rezultat:");

        firstNumber.setBounds(40, 40, 120, 30);
        secondNumber.setBounds(180, 40, 120, 30);
        answer.setBounds(40, 160, 300, 30);

        String[] ops = {"+", "-", "×", "÷", "xʸ"};
        for (int i = 0; i < ops.length; i++) {
            final String op = ops[i];
            JButton b = new JButton(op);
            b.setBounds(40 + i * 58, 100, 52, 36);
            b.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    answer.setText(calculate(firstNumber.getText(), secondNumber.getText(), op));
                }
            });
            f.add(b);
        }

        f.add(firstNumber);
        f.add(secondNumber);
        f.add(answer);

        f.setSize(360, 260);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    static String calculate(String aText, String bText, String op) {
        try {
            double a = logic.parse(aText);
            double b = logic.parse(bText);
            double r;
            switch (op) {
                case "+": r = logic.add(a, b); break;
                case "-": r = logic.subtract(a, b); break;
                case "×": r = logic.multiply(a, b); break;
                case "÷": r = logic.divide(a, b); break;
                default:  r = logic.power(a, b);
            }
            return "Rezultat: " + logic.format(r);
        } catch (NumberFormatException ex) {
            return "Introduceți două numere";        // de ex. o literă în loc de cifră
        } catch (ArithmeticException ex) {
            return "Nu se poate împărți la zero";
        }
    }
}

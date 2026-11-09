package lectia8.swing;

import java.awt.event.*;
import javax.swing.*;

/**
 * Sarcina „Calculator” (diapozitivele 31–35): două câmpuri, un buton „+”, rezultatul într-un label.
 * Întrebare pentru clasă: ce se întâmplă dacă scriem o literă? -> NumberFormatException în consolă.
 * Varianta completă, cu toate operațiile și protecție la erori, e în pachetul homework.
 */
public class Calculator {

    public static void main(String[] args) {
        JFrame f = new JFrame("Calculator");

        // 1. Două câmpuri de input și un label pentru rezultat
        final JTextField firstNumber = new JTextField();
        final JTextField secondNumber = new JTextField();
        final JLabel answer = new JLabel();

        // 2. Le punem pe poziții și adăugăm butonul
        firstNumber.setBounds(50, 50, 50, 20);
        secondNumber.setBounds(150, 50, 50, 20);
        answer.setBounds(250, 50, 50, 20);

        JButton b = new JButton("+");
        b.setBounds(50, 100, 95, 30);

        // 3. Logica: luăm două numere, le adunăm, afișăm rezultatul
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = Integer.parseInt(firstNumber.getText());
                int c = Integer.parseInt(secondNumber.getText());
                answer.setText(String.valueOf(a + c));
            }
        });

        // 4. Adăugăm toate componentele pe ecran
        f.add(b);
        f.add(firstNumber);
        f.add(secondNumber);
        f.add(answer);

        f.setSize(400, 400);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}

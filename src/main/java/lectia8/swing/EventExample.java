package lectia8.swing;

import java.awt.event.*;   // fără acest import, ActionListener e roșu
import javax.swing.*;

/**
 * Pasul 2 (diapozitivele 26–30): evenimente.
 * La apăsarea butonului, în câmpul de text apare un mesaj.
 */
public class EventExample {

    public static void main(String[] args) {
        JFrame f = new JFrame("Button Example");

        final JTextField tf = new JTextField();    // câmp pentru input
        tf.setBounds(50, 50, 150, 20);

        JButton b = new JButton("Click Here");
        b.setBounds(50, 100, 95, 30);

        // ActionListener răspunde de procesarea evenimentului "apăsare pe buton"
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf.setText("Welcome to Swing");
            }
        });

        f.add(b);
        f.add(tf);
        f.setSize(400, 400);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}

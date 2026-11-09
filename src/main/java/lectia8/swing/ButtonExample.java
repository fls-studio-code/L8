package lectia8.swing;

import javax.swing.*;

/**
 * Pasul 1 (diapozitivele 21–25): o fereastră cu un buton.
 * Toate elementele se adaugă separat, unul câte unul.
 */
public class ButtonExample {

    public static void main(String[] args) {
        JFrame f = new JFrame("Button Example");   // fereastra = "ecranul" nostru

        JButton b = new JButton("Click Here");     // între ghilimele: textul de pe buton
        b.setBounds(50, 100, 95, 30);              // x, y (poziția), lățime, înălțime
        f.add(b);                                  // add: pune elementul pe ecran

        f.setSize(400, 400);                       // dimensiunea ferestrei
        f.setLayout(null);                         // poziționăm noi elementele, cu setBounds
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // programul se oprește la închidere
        f.setVisible(true);                        // fără asta fereastra nu apare
    }
}

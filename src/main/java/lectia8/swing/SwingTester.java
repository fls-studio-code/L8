package lectia8.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Sarcina „Paleta” (diapozitivele 36–39): alegem o culoare, textul își schimbă culoarea.
 * Observați importurile: o parte din java.awt, o parte din javax.swing și javax.swing.event.
 */
public class SwingTester {

    public static void main(String[] args) {
        createWindow();
    }

    private static void createWindow() {
        JFrame frame = new JFrame("Swing Tester");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createUI(frame);
        frame.setSize(650, 400);
        frame.setLocationRelativeTo(null);   // fereastra apare în centrul ecranului
        frame.setVisible(true);
    }

    private static void createUI(final JFrame frame) {
        JPanel panel = new JPanel();
        LayoutManager layout = new FlowLayout();   // elementele se așază automat, unul după altul
        panel.setLayout(layout);

        final JLabel colorLabel = new JLabel("Color Chooser Example");
        final JColorChooser colorChooser = new JColorChooser();

        // ChangeListener: se apelează de fiecare dată când alegem altă culoare
        colorChooser.getSelectionModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                Color color = colorChooser.getColor();
                colorLabel.setForeground(color);
            }
        });

        panel.add(colorLabel);
        panel.add(colorChooser);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
    }
}

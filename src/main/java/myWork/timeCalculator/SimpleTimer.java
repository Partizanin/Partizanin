package myWork.timeCalculator;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionListener;


/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 20.10.2014
 * Time:  15:55
 * To change this template use File|Setting|File Templates.
 */

public class SimpleTimer extends JFrame {
    private JLabel label;
    private Timer timer;
    private int counter = 10; // the duration
    private int delay = 1000; // every 1 second
    private static final long serialVersionUID = 1L;

    public SimpleTimer() {
        super("Simple MyTimer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        label = new JLabel("Wait for " + counter + " sec", JLabel.CENTER);
        JPanel contentPane = (JPanel) getContentPane();
        contentPane.add(label, BorderLayout.CENTER);
        contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pack();

        ActionListener action = event -> {
            if (counter == 0) {
                timer.stop();
                label.setText("The time is up!");
            } else {
                label.setText("Wait for " + counter + " sec");
                counter--;
            }
        };

        timer = new Timer(delay, action);
        timer.setInitialDelay(0);
        timer.start();

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SimpleTimer::new);
    }
}
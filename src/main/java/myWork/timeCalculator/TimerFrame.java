package myWork.timeCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalTime;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 19.10.2014
 * Time:  17:40
 * To change this template use File|Setting|File Templates.
 */
public class TimerFrame extends JFrame {

    private JTextArea area = new JTextArea();
    private JPanel p = new JPanel();
    private JButton pause = new JButton(new ImageIcon("D:\\Illia\\Java\\Projects\\Partizanin\\src\\main\\java\\myWork\\timeCalculator\\icons\\Button-2-pause-icon.png"));
    private JButton play = new JButton(new ImageIcon("D:\\Illia\\Java\\Projects\\Partizanin\\src\\main\\java\\myWork\\timeCalculator\\icons\\play-icon.png"));
    private JButton returnBack = new JButton(new ImageIcon("D:\\Illia\\Java\\Projects\\Partizanin\\src\\main\\java\\myWork\\timeCalculator\\icons\\reload-icon.png"));
    private String t1;
    private String t2;

    public TimerFrame() throws HeadlessException {
        p.setLayout(null);

        area.setBounds(75, 80, 200, 35);
        area.setText("00:00:05");
        area.setFont(new Font("Arial", Font.BOLD, 30));
        area.setForeground(Color.RED);
        area.setBackground(new Color(60, 63, 65));

        pause.setBounds(8, 8, 64, 64);
        pause.setFocusPainted(false);
        pause.setContentAreaFilled(false);

        play.setBounds(115, 8, 64, 64);
        play.setFocusPainted(false);
        play.setContentAreaFilled(false);

        returnBack.setBounds(220, 8, 64, 64);
        returnBack.setFocusPainted(false);
        returnBack.setContentAreaFilled(false);


        p.setBackground(new Color(60, 63, 65));
        setVisible(true);
        setSize(300, 150);
        setLocation(500, 300);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        p.add(area);
        p.add(pause);
        p.add(play);
        p.add(returnBack);

        Timer timer = new Timer(1000, action);
        timer.setInitialDelay(0);
        timer.start();

        play.addActionListener(buttonListener);

        getContentPane().add(p);

    }

    ActionListener action = e -> {

    };

    ActionListener buttonListener = e -> {
        JButton clickButton = (JButton) e.getSource();


        if (clickButton.equals(play)) {

            timer(area.getText());

        }
    };


    private static LocalTime init(String START_TIME) {
        return LocalTime.of(Integer.parseInt(START_TIME.substring(0, 2)),
                Integer.parseInt(START_TIME.substring(3, 5)),
                Integer.parseInt(START_TIME.substring(6, 8)));
    }

    public void timer(String timeStart) {

        LocalTime time = init(timeStart);

        for (; ; ) {
            if (!time.toString().equals("00:00")) {
                try {
                    area.setText(time.toString());
                    area.updateUI();
                    Thread.currentThread();
                    Thread.sleep(25);
                    time = time.minusNanos(25000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            } else if (time.toString().equals("00:00")) {

                break;
            }

        }
    }

    public String getT2() {

        return t2;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TimerFrame::new);
    }


}

package myWork.timeCalculator;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 05.10.2014
 * Time:  14:17
 * To change this template use File|Setting|File Templates.
 */
public class MainWindow extends JFrame {

    private final JTextField textField1 = new JTextField();
    private final JTextField textField2 = new JTextField();

    private final JTextField textField1F = new JTextField();
    private final JTextField textField2F = new JTextField();


    private final JLabel labelPlus = new JLabel("");
    private final JLabel labelMinus = new JLabel("_");
    private final JLabel labelEquals = new JLabel("");

    private final JLabel labelPlusF = new JLabel("+");
    private final JLabel labelMinusF = new JLabel("");
    private final JLabel labelEqualsF = new JLabel("");
    private final JTextArea textArea = new JTextArea("");
    private final JButton buttonCount = new JButton("=");
    private final JButton buttonCountF = new JButton("=");
    private final JLabel labelTimeCount = new JLabel("Хвилини");
    ImageIcon ico = new ImageIcon("D:\\Illia\\Java\\Projects\\proff16\\Partizanin\\src\\main\\java\\myWork\\timeCalculator\\left_48.png");
    private final JButton buttonReturnValue = new JButton(ico);
    private final JButton buttonReturnValue2 = new JButton(ico);
    ImageIcon icoWarn = new ImageIcon("D:\\Illia\\Java\\Projects\\proff16\\Partizanin\\src\\main\\java\\myWork\\timeCalculator\\warning_48.png");
    private final JLabel labelWarn = new JLabel(icoWarn);
    ImageIcon icoUp = new ImageIcon("D:\\Illia\\Java\\Projects\\proff16\\Partizanin\\src\\main\\java\\myWork\\timeCalculator\\up_48.png");
    private final JButton textUp = new JButton(icoUp);
    ImageIcon icoDown = new ImageIcon("D:\\Illia\\Java\\Projects\\proff16\\Partizanin\\src\\main\\java\\myWork\\timeCalculator\\down_48.png");
    private final JButton textDown = new JButton(icoDown);
    PlainDocument plainDocument1 = new PlainDocument() {

        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            String chars = "1234567890";
            textArea.setVisible(false);
            labelWarn.setVisible(false);
            if (offs == 9) {
                textField1.setText("");
                super.insertString(0, str, a);
            }
            if (getLength() > 7 || !chars.contains(str)) {
                return;
            }
/*
            if (getLength() > 7 ){
                super.replace(offs,0,str,a);
            }*/
            if (getLength() > 1 && getLength() < 3
                    || getLength() > 4 && getLength() < 6) {

                str = ":" + str;
                super.insertString(offs, str, a);
            } else {
                super.insertString(offs, str, a);
            }
        }


    };
    PlainDocument plainDocument2 = new PlainDocument() {
        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            String chars = "1234567890";
            if (getLength() > 7 || !chars.contains(str)) {
                return;
            }
            textArea.setVisible(false);
            labelWarn.setVisible(false);
            if (getLength() > 1 && getLength() < 3
                    || getLength() > 4 && getLength() < 6) {

                str = ":" + str;
                super.insertString(offs, str, a);
            } else {
                super.insertString(offs, str, a);
            }
        }


    };
    PlainDocument plainDocument4 = new PlainDocument() {
        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            String chars = "1234567890+-";
            textArea.setVisible(false);
            labelWarn.setVisible(false);


            if (!chars.contains(str)) {
                //noinspection UnnecessaryReturnStatement
                return;
            } else {

                if (getLength() == 0 && str.equals("+") || getLength() == 0 && str.equals("-")) {
                    return;
                }

                if (!textField2F.getText().equals("")) {


                    String text = textField2F.getText();

                    if (text.charAt(text.length() - 1) == '-' && str.equals("-") ||
                            text.charAt(text.length() - 1) == '+' && str.equals("+") ||
                            text.charAt(text.length() - 1) == '-' && str.equals("+") ||
                            text.charAt(text.length() - 1) == '+' && str.equals("-")) {
                        return;
                    }
                }

                super.insertString(offs, str, a);
            }
        }


    };
    PlainDocument plainDocument3 = new PlainDocument() {
        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            String chars = "1234567890";
            textArea.setVisible(false);
            labelWarn.setVisible(false);

            if (offs == 9) {
                textField1F.setText("");
                super.insertString(0, str, a);

            }
            if (getLength() > 7 || !chars.contains(str)) {
                return;

            }

            if (getLength() > 1 && getLength() < 3
                    || getLength() > 4 && getLength() < 6) {

                str = ":" + str;
                super.insertString(offs, str, a);
            } else {
                super.insertString(offs, str, a);
            }
        }


    };
    private JMenuItem menuMinus;

    private MainWindow() {


        textArea.setRows(2);


        JPanel p1 = new JPanel();
        p1.setLayout(null);

        //x y width height


        textField1.setBounds(20, 25, 91, 40);
        textField1.setFont(new Font("", Font.PLAIN, 22));

        textField1F.setBounds(20, 90, 91, 40);
        textField1F.setFont(new Font("", Font.PLAIN, 22));

        labelMinus.setBounds(130, 7, 20, 42);

        labelPlus.setBounds(130, 22, 20, 42);

        labelMinusF.setBounds(130, 77, 20, 42);

        labelPlusF.setBounds(130, 92, 20, 42);

        labelTimeCount.setBounds(160, 92, 70, 42);
        labelTimeCount.setForeground(Color.RED);
        labelTimeCount.setFont(new Font("Serif", Font.BOLD, 15));

        textField2.setBounds(170, 25, 91, 40);

        textField2.setFont(new Font("", Font.PLAIN, 22));

        textField2F.setBounds(230, 95, 91, 40);
        textField2F.setFont(new Font("", Font.PLAIN, 22));

        labelEquals.setBounds(350, 25, 200, 40);
        labelEquals.setFont(new Font("", Font.BOLD, 22));
        labelEquals.setForeground(Color.DARK_GRAY);

        labelEqualsF.setBounds(410, 95, 200, 40);
        labelEqualsF.setFont(new Font("", Font.BOLD, 22));
        labelEqualsF.setForeground(Color.DARK_GRAY);

        buttonReturnValue.setBounds(450, 25, 48, 48);
        buttonReturnValue.setFocusPainted(false);
        buttonReturnValue.setContentAreaFilled(false);

        textUp.setBounds(558, 95, 48, 48);
        textUp.setFocusPainted(false);
        textUp.setContentAreaFilled(false);

        textDown.setBounds(498, 25, 48, 48);
        textDown.setFocusPainted(false);
        textDown.setContentAreaFilled(false);

        buttonReturnValue2.setBounds(510, 95, 48, 48);
        buttonReturnValue2.setFocusPainted(false);
        buttonReturnValue2.setContentAreaFilled(false);

        buttonCount.setBounds(280, 25, 60, 40);
        buttonCount.setFont(new Font("Serif", Font.BOLD, 30));

        buttonCountF.setBounds(340, 95, 60, 40);
        buttonCountF.setFont(new Font("Serif", Font.BOLD, 30));


        labelMinus.setForeground(Color.RED);
        labelMinus.setFont(new Font("Serif", Font.BOLD, 30));

        labelMinusF.setForeground(Color.RED);
        labelMinusF.setFont(new Font("Serif", Font.BOLD, 30));


        labelPlus.setForeground(Color.RED);
        labelPlus.setFont(new Font("Serif", Font.BOLD, 30));


        labelPlusF.setForeground(Color.RED);
        labelPlusF.setFont(new Font("Serif", Font.BOLD, 30));

        textArea.setFont(new Font("Serif", Font.BOLD, 30));

        textArea.setForeground(Color.RED);


        textArea.setBackground(p1.getBackground());

        textArea.setBounds(91, 150, 450, 100);
        labelWarn.setBounds(20, 150, 48, 48);

        textArea.setEditable(false);
        textArea.setVisible(false);
        labelWarn.setVisible(false);

        p1.add(textArea);
        p1.add(labelTimeCount);
        p1.add(textField1);
        p1.add(textField2);
        p1.add(buttonCount);
        p1.add(buttonCountF);
        p1.add(labelPlus);
        p1.add(labelMinus);
        p1.add(labelEquals);
        p1.add(labelEqualsF);
        p1.add(labelMinusF);
        p1.add(labelPlusF);
        p1.add(textField1F);
        p1.add(textField2F);
        p1.add(buttonReturnValue);
        p1.add(buttonReturnValue2);
        p1.add(textUp);
        p1.add(textDown);
        p1.add(labelWarn);


        add(p1);
        setSize(605, 265);
        setLocation(300, 250);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        textField1.setColumns(20);

        ButtonListener listener = new ButtonListener(this);
        ButtonListener2 listener2 = new ButtonListener2(this);
        buttonCount.addActionListener(listener);
        buttonCountF.addActionListener(listener2);
        buttonReturnValue.addActionListener(listener);
        buttonReturnValue2.addActionListener(listener2);
        textUp.addActionListener(listener2);
        textDown.addActionListener(listener);
        setTitle("Frame2");


        textField1.setDocument(plainDocument1);

        textField2.setDocument(plainDocument2);
        textField1F.setDocument(plainDocument3);
        textField2F.setDocument(plainDocument4);

        MenuListener menuListener = new MenuListener(this);
        JPopupMenu p = new JPopupMenu();
        /*labelMinus.setComponentPopupMenu(p);*/
        labelPlus.setComponentPopupMenu(p);


        menuMinus = new JMenuItem("_");
        menuMinus.addActionListener(menuListener);
        p.add(menuMinus);
        p.addSeparator();
        JMenuItem menuPlus = new JMenuItem("+");
        menuPlus.addActionListener(menuListener);
        p.add(menuPlus);

        MenuListener2 menuListener2 = new MenuListener2(this);
        JPopupMenu p2 = new JPopupMenu();
        labelMinusF.setComponentPopupMenu(p2);
        labelPlusF.setComponentPopupMenu(p2);


        menuMinus = new JMenuItem("_");
        menuMinus.addActionListener(menuListener2);
        p2.add(menuMinus);
        p2.addSeparator();
        menuPlus = new JMenuItem("+");
        menuPlus.addActionListener(menuListener2);
        p2.add(menuPlus);


        MenuListener3 menuListener3 = new MenuListener3(this);
        JPopupMenu p3 = new JPopupMenu();
        labelTimeCount.setComponentPopupMenu(p3);

        JMenuItem timeMenu = new JMenuItem("Години");
        timeMenu.addActionListener(menuListener3);
        p3.add(timeMenu);
        p3.addSeparator();
        timeMenu = new JMenuItem("Хвилини");
        timeMenu.addActionListener(menuListener3);
        p3.add(timeMenu);
        p3.addSeparator();
        timeMenu = new JMenuItem("Секунди");
        timeMenu.addActionListener(menuListener3);
        p3.add(timeMenu);


    }

    private static String timePlus(String getTime1, String getTime2) {
        String hour = getTime1.substring(0, 2);
        String minutes = getTime1.substring(3, 5);
        String seconds = getTime1.substring(6, 8);

        LocalTime time = LocalTime.of(Integer.parseInt(hour), Integer.parseInt(minutes), Integer.parseInt(seconds));

        String hour2 = getTime2.substring(0, 2);
        String minutes2 = getTime2.substring(3, 5);
        String seconds2 = getTime2.substring(6, 8);

        time = time.plusHours(Integer.parseInt(hour2));
        time = time.plusMinutes(Integer.parseInt(minutes2));
        time = time.plusSeconds(Integer.parseInt(seconds2));

        return time.toString();
    }

    private static String timeMinus(String getTime1, String getTime2) {

        LocalTime time = LocalTime.of(Integer.parseInt(getTime1.substring(0, 2)),
                Integer.parseInt(getTime1.substring(3, 5)), Integer.parseInt(getTime1.substring(6, 8)));

        time = time.minusHours(Integer.parseInt(getTime2.substring(0, 2)));
        time = time.minusMinutes(Integer.parseInt(getTime2.substring(3, 5)));
        time = time.minusSeconds(Integer.parseInt(getTime2.substring(6, 8)));

        return time.toString();
    }

    private static Long getTextValue(String textValue) {

        String setText = "";

        if (textValue.charAt(textValue.length() - 1) == '+' ||
                textValue.charAt(textValue.length() - 1) == '-') {

            setText += textValue.substring(0, textValue.length() - 1);

            textValue = setText;
        }

        int summ = 0;
        String value = "";
        String operation = "";
        String operation2 = "";
        boolean firstVal = false;

        for (int i = 0; i < textValue.length(); i++) {


            if (!firstVal) {

                if (textValue.charAt(i) == '+' || textValue.charAt(i) == '-') {

                    operation += textValue.charAt(i);
                    firstVal = true;
                    summ += Integer.parseInt(value);
                    value = "";
                } else {
                    value += textValue.charAt(i);

                    if (!textValue.contains("+") && !textValue.contains("-") && i == textValue.length() - 1) {
                        summ += Integer.parseInt(value);
                    }
                }
            } else {

                if (i == textValue.length() - 1) {
                    if (operation.equals("+")) {
                        summ += Integer.parseInt(value += String.valueOf(textValue.charAt(i)));
                    } else {
                        summ -= Integer.parseInt(value += String.valueOf(textValue.charAt(i)));
                    }
                } else if (textValue.charAt(i) == '+' || textValue.charAt(i) == '-') {
                    operation2 += textValue.charAt(i);

                    if (operation.equals("+")) {
                        summ += Integer.parseInt(value);
                    } else {
                        summ -= Integer.parseInt(value);
                    }


                    operation = operation2;
                    operation2 = "";
                    value = "";
                } else if (textValue.charAt(i) != '+' && textValue.charAt(i) != '-') {
                    value += textValue.charAt(i);
                }

            }

        }

        return (long) summ;
    }

    private static String testTime(String textValue) {

        int hour = Integer.parseInt(textValue.substring(0, 2));
        int minutes = Integer.parseInt(textValue.substring(3, 5));
        int seconds = Integer.parseInt(textValue.substring(6, 8));

        if (hour > 23) {
            return "Значення годин не може бути\n більше 23!";
        } else if (minutes > 60) {
            return "Значення хвилини не може бути\n більше 60!";
        } else if (seconds > 60) {
            return "Значення секунди не може бути\n більше 60!";
        }

        return "";
    }

    public static void main(String[] args) {
        new MainWindow();
    }

    String timePlusMinutes(String getTime1, String getTime2) {
        String hour = getTime1.substring(0, 2);
        String minutes = getTime1.substring(3, 5);
        String seconds = getTime1.substring(6, 8);


        LocalTime time = LocalTime.of(Integer.parseInt(hour), Integer.parseInt(minutes), Integer.parseInt(seconds));


        time = time.plusMinutes(getTextValue(getTime2));


        return time.toString();
    }

    String timePlusHours(String getTime1, String getTime2) {
        String hour = getTime1.substring(0, 2);
        String minutes = getTime1.substring(3, 5);
        String seconds = getTime1.substring(6, 8);


        LocalTime time = LocalTime.of(Integer.parseInt(hour), Integer.parseInt(minutes), Integer.parseInt(seconds));


        time = time.plusHours(getTextValue(getTime2));


        return time.toString();
    }

    String timePlusSeconds(String getTime1, String getTime2) {
        String hour = getTime1.substring(0, 2);
        String minutes = getTime1.substring(3, 5);
        String seconds = getTime1.substring(6, 8);


        LocalTime time = LocalTime.of(Integer.parseInt(hour), Integer.parseInt(minutes), Integer.parseInt(seconds));


        time = time.plusSeconds(getTextValue(getTime2));


        return time.toString();
    }

    String timeMinusMinutes(String getTime1, String getTime2) {
        String hour = getTime1.substring(0, 2);
        String minutes = getTime1.substring(3, 5);
        String seconds = getTime1.substring(6, 8);


        LocalTime time = LocalTime.of(Integer.parseInt(hour), Integer.parseInt(minutes), Integer.parseInt(seconds));


        time = time.minusMinutes(getTextValue(getTime2));


        return time.toString();
    }

    String timeMinusHours(String getTime1, String getTime2) {
        String hour = getTime1.substring(0, 2);
        String minutes = getTime1.substring(3, 5);
        String seconds = getTime1.substring(6, 8);


        LocalTime time = LocalTime.of(Integer.parseInt(hour), Integer.parseInt(minutes), Integer.parseInt(seconds));


        time = time.minusHours(getTextValue(getTime2));


        return time.toString();
    }

    String timeMinusSeconds(String getTime1, String getTime2) {
        String hour = getTime1.substring(0, 2);
        String minutes = getTime1.substring(3, 5);
        String seconds = getTime1.substring(6, 8);


        LocalTime time = LocalTime.of(Integer.parseInt(hour), Integer.parseInt(minutes), Integer.parseInt(seconds));


        time = time.minusSeconds(getTextValue(getTime2));


        return time.toString();
    }

    public class MenuListener implements ActionListener {
        final MainWindow parent;

        MenuListener(MainWindow parent) {
            this.parent = parent;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if (labelMinus.getText().equals("_")) {
                labelMinus.setText("");
                labelPlus.setText(((JMenuItem) e.getSource()).getText());
            } else {

                labelPlus.setText("");
                labelMinus.setText(((JMenuItem) e.getSource()).getText());
            }
        }
    }

    public class MenuListener2 implements ActionListener {
        final MainWindow parent;

        MenuListener2(MainWindow parent) {
            this.parent = parent;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JMenuItem clickedMenu = (JMenuItem) e.getSource();

            if (clickedMenu.equals(parent.menuMinus)) {
                labelPlusF.setText("");
                labelMinusF.setText(((JMenuItem) e.getSource()).getText());
            } else {
                labelMinusF.setText("");
                labelPlusF.setText(((JMenuItem) e.getSource()).getText());
            }
        }
    }

    public class MenuListener3 implements ActionListener {
        final MainWindow parent;

        MenuListener3(MainWindow parent) {
            this.parent = parent;
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            JMenuItem clickedMenu = (JMenuItem) e.getSource();

            if (clickedMenu.getText().equals("Години")) {
                labelTimeCount.setText("Години");
            } else if (clickedMenu.getText().equals("Хвилини")) {
                labelTimeCount.setText("Хвилини");
            } else if (clickedMenu.getText().equals("Секунди")) {
                labelTimeCount.setText("Секунди");
            }
        }
    }

    public class ButtonListener implements ActionListener {

        final MainWindow parent;

        ButtonListener(MainWindow parent) {
            this.parent = parent;
        }


        @Override
        public void actionPerformed(ActionEvent e) {

            JButton clickedButton = (JButton) e.getSource();
            textArea.setText("");
            if (clickedButton.equals(parent.textDown)) {
                try {
                    plainDocument3.insertString(9, labelEquals.getText(), null);
                } catch (BadLocationException e1) {
                    e1.printStackTrace();
                }
            } else if (clickedButton.equals(parent.buttonReturnValue)) {
                try {
                    plainDocument1.insertString(9, labelEquals.getText(), null);
                } catch (BadLocationException e1) {
                    e1.printStackTrace();
                }


            } else if (clickedButton.equals(parent.buttonCount)) {

                boolean error = false;
                try {

                    textField1.getText();
                    textField2.getText();
                    textField1.getText().substring(8);
                    textField2.getText().substring(8);

                    String test = testTime(textField1.getText());

                    if (!test.equals("")) {
                        textArea.setText(test);
                        textArea.setVisible(true);
                        labelWarn.setVisible(true);

                        error = true;
                    }
                    test = testTime(textField2.getText());
                    if (!test.equals("")) {
                        textArea.setText(test);
                        textArea.setVisible(true);
                        labelWarn.setVisible(true);
                        error = true;
                    }

                } catch (NullPointerException ex) {
                    textArea.setText("Будьласка заповніть всі поля!");
                    textArea.setVisible(true);
                    labelWarn.setVisible(true);
                    error = true;


                } catch (IndexOutOfBoundsException ee) {

                    textArea.setText("Будьласка заповніть всі поля!");
                    textArea.setVisible(true);
                    labelWarn.setVisible(true);

                    error = true;
                }


                if (!error) {


                    if (!labelMinus.getText().equals("")) {
                        labelEquals.setText(timeMinus(textField1.getText(), textField2.getText()));

                    } else {
                        labelEquals.setText(timePlus(textField1.getText(), textField2.getText()));
                    }
                }

            }
        }
    }

    public class ButtonListener2 implements ActionListener {

        final MainWindow parent;

        ButtonListener2(MainWindow parent) {
            this.parent = parent;
        }


        @Override
        public void actionPerformed(ActionEvent e) {

            JButton clickedButton = (JButton) e.getSource();
            textArea.setText("");
            if (clickedButton.equals(parent.textUp)) {
                try {
                    plainDocument1.insertString(9, labelEqualsF.getText(), null);
                } catch (BadLocationException e1) {
                    e1.printStackTrace();
                }
            } else if (clickedButton.equals(parent.buttonReturnValue2)) {
                try {
                    plainDocument3.insertString(9, labelEqualsF.getText(), null);
                } catch (BadLocationException e1) {
                    e1.printStackTrace();
                }
            } else if (clickedButton.equals(parent.buttonCountF)) {

                boolean error = false;
                try {
                    textField1F.getText();
                    textField2F.getText();
                    textField1F.getText().substring(8);
                    textField2F.getText().substring(1);

                    String test = testTime(textField1F.getText());
                    if (!test.equals("")) {
                        textArea.setText(test);
                        textArea.setVisible(true);
                        labelWarn.setVisible(true);
                        error = true;
                    }

                } catch (NullPointerException ex) {
                    textArea.setText("Будьласка заповніть всі поля!");
                    textArea.setVisible(true);
                    labelWarn.setVisible(true);
                    error = true;


                } catch (IndexOutOfBoundsException ee) {

                    textArea.setText("Будьласка заповніть всі поля!");
                    textArea.setVisible(true);
                    labelWarn.setVisible(true);

                    error = true;
                }


                if (!error) {


                    if (!labelMinusF.getText().equals("")) {

                        if (labelTimeCount.getText().equals("Години")) {
                            labelEqualsF.setText(timeMinusHours(textField1F.getText(), textField2F.getText()));
                        } else if (labelTimeCount.getText().equals("Хвилини")) {
                            labelEqualsF.setText(timeMinusMinutes(textField1F.getText(), textField2F.getText()));
                        } else if (labelTimeCount.getText().equals("Секунди")) {
                            labelEqualsF.setText(timeMinusSeconds(textField1F.getText(), textField2F.getText()));
                        }

                    } else {

                        if (labelTimeCount.getText().equals("Години")) {
                            labelEqualsF.setText(timePlusHours(textField1F.getText(), textField2F.getText()));
                        } else if (labelTimeCount.getText().equals("Хвилини")) {
                            labelEqualsF.setText(timePlusMinutes(textField1F.getText(), textField2F.getText()));
                        } else if (labelTimeCount.getText().equals("Секунди")) {
                            labelEqualsF.setText(timePlusSeconds(textField1F.getText(), textField2F.getText()));
                        }

                    }
                }

            }
        }
    }

}


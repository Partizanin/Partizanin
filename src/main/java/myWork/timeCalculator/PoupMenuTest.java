package myWork.timeCalculator;

import javax.swing.*;
import java.awt.*;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 09.10.2014
 * Time:  16:36
 * To change this template use File|Setting|File Templates.
 */
public class PoupMenuTest {
    private JFrame frame;

    public PoupMenuTest() {
        // create JFrame with title
        frame = new JFrame("Icon Example");
        frame.setSize(300, 300);
        frame.setLocation(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // make an icon from the .jpg file
        ImageIcon antIcon = new ImageIcon("D:\\Illia\\Java\\Projects\\proff16\\Partizanin\\src\\main\\java\\myWork\\timeCalculator\\icon.jpg");

        // a button with an icon and text
        JButton button1 = new JButton("Ant Button", antIcon);
        frame.add(BorderLayout.NORTH, button1);

        // a label with both text and an Icon
        JLabel label1 = new JLabel("Label with Image and Text", antIcon, JLabel.CENTER);

        //Set the position of the text, relative to the icon:
        label1.setVerticalTextPosition(JLabel.BOTTOM);
        label1.setHorizontalTextPosition(JLabel.CENTER);
        frame.add(BorderLayout.SOUTH, label1);
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        PoupMenuTest iconEx = new PoupMenuTest();

    }
}


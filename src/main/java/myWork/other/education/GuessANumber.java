package myWork.other.education;

import java.time.LocalTime;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin.
 * User: Partizanin.
 * Date: 12.11.2014.
 * Time:  22:06.
 * To change this template use File|Setting|Editor|File and Code Templates.
 */
public class GuessANumber extends Thread {
    private int number;

    public GuessANumber(int number) {
        this.number = number;
    }

    public void run() {
        int counter = 0;
        int guess = 0;
        do {
            guess = (int) (Math.random() * 100 + 1);
            System.out.println(this.getName()
                    + " guesses " + guess + " " + LocalTime.now());
            counter++;
        } while (guess != number);
        System.out.println("** Correct! " + this.getName()
                + " in " + counter + " guesses.**" + " " + LocalTime.now());
    }
}


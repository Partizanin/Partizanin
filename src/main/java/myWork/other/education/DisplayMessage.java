package myWork.other.education;

import java.time.LocalTime;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin.
 * User: Partizanin.
 * Date: 12.11.2014.
 * Time:  22:05.
 * To change this template use File|Setting|Editor|File and Code Templates.
 */
public class DisplayMessage implements Runnable {
    private String message;
    private int count = 0;

    public DisplayMessage(String message) {
        this.message = message;
    }

    public void run() {
        while (true) {
            System.out.println(message + " " + count + " " + LocalTime.now());

            count++;
        }
    }
}


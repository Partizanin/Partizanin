package myWork.timeCalculator;

import java.awt.event.ActionListener;
import java.time.LocalTime;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 20.10.2014
 * Time:  14:21
 * To change this template use File|Setting|File Templates.
 */
public class MyTimer {

    private static String START_TIME;

    private String current_time;
    private int initialDelay;

    public MyTimer(String START_TIME) {
        MyTimer.START_TIME = START_TIME;
        current_time = START_TIME;
    }

    public MyTimer(int delay, ActionListener action) {

    }


    public static void main(String[] args) {
        MyTimer timer = new MyTimer("00:00:05");
        timer.start();
    }

    private static LocalTime init() {
        return LocalTime.of(Integer.parseInt(START_TIME.substring(0, 2)),
                Integer.parseInt(START_TIME.substring(3, 5)),
                Integer.parseInt(START_TIME.substring(6, 8)));
    }

    public void start() {


        LocalTime time = init();

        for (; ; ) {
            if (!time.toString().equals("00:00")) {
                try {
                    current_time = time.toString();
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

    public static void stop() {

    }

    public String getSTART_TIME() {
        return START_TIME;
    }

    public String getCurrent_time() {
        return current_time;
    }

    public void setInitialDelay(int initialDelay) {
        this.initialDelay = initialDelay;
    }

    public int getInitialDelay() {
        return initialDelay;
    }
}

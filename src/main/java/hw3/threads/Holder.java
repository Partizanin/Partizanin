package hw3.threads;

import java.time.LocalTime;

/**
 * Created with Intellij IDEA.
 * Project name: Курсы
 * User: Partizanin
 * Date: 19.05.2014
 * Time: 11:50
 * To change this template use File|Setting|File Templates.
 */

public class Holder {
    int number;
    boolean valueSet = false;
    int count = 0;
    private static Holder INSTANCE;

    private int timeSleep  = 600;

    private Holder(int count,int timeSleep) {

        if (count == 0) {
            count = 5;
        }
        if (timeSleep != 0) {

            this.timeSleep = timeSleep;
        }

        this.count = count;
    }

    public static synchronized Holder getINSTANCE(int count,int timeSleep) {
        if (INSTANCE == null) {
            if (count == 0) {
                count = 5;
            }

            INSTANCE = new Holder(count,timeSleep);
        }
        return INSTANCE;
    }

    /* private static Singleton instance;

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }*/

    synchronized int get() {
        while (!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        System.out.println("Получено: " + number + " " + LocalTime.now());
        valueSet = false;
        try {
            Thread.sleep(timeSleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notify();
        return number;

    }

    synchronized void set(int n) {
        while (valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.number = n;
        valueSet = true;
        System.out.println("Отправлено: " + n + " " + LocalTime.now());

        try {
            Thread.sleep(timeSleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notify();
    }
}

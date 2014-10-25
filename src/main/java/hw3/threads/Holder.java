package hw3.threads;

/**
 * Created with Intellij IDEA.
 * Project name: Курсы
 * User: Partizanin
 * Date: 19.05.2014
 * Time: 11:50
 * To change this template use File|Setting|File Templates.
 */

public class Holder {
    int n;
    boolean valueSet = false;
    int count = 0;
    private static Holder INSTANCE;

    private Holder(int count) {
        this.count = count;
    }

    public static synchronized Holder getINSTANCE(int count) {
        if (INSTANCE == null) {
            INSTANCE = new Holder(count);
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

        System.out.println("Получено: " + n);
        valueSet = false;

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notify();
        return n;

    }

    synchronized void set(int n) {
        while (valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.n = n;
        valueSet = true;
        System.out.println("Отправлено: " + n);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notify();
    }
}

package myWork.other.education;

import java.time.LocalTime;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin.
 * User: Partizanin.
 * Date: 12.11.2014.
 * Time:  21:59.
 * To change this template use File|Setting|Editor|File and Code Templates.
 */
class RunnableDemo implements Runnable {
    private Thread t;
    private String threadName;

    RunnableDemo(String name) {
        threadName = name;
        System.out.println("Creating " + threadName + " " + LocalTime.now());
    }

    public void run() {
        System.out.println("Running " + threadName + " " + LocalTime.now());
        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i + " " + LocalTime.now());
                // Let the thread sleep for a while.
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted." + " " + LocalTime.now());
        }
        System.out.println("Thread " + threadName + " exiting." + " " + LocalTime.now());
    }

    public void start() {
        System.out.println("Starting " + threadName + " " + LocalTime.now());
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }

}


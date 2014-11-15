package myWork.other.education;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Formatter;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin.
 * User: Partizanin.
 * Date: 12.11.2014.
 * Time:  21:19.
 * To change this template use File|Setting|Editor|File and Code Templates.
 */
public class MultiThread implements Runnable {

    public void start() {
        ((Runnable) () -> {
            System.out.println(LocalTime.now() + "Start");
        }).run();
    }


    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        MultiThread m = new MultiThread();
        m.run();
        System.out.println(Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        Thread.currentThread().setName("My Thread");
        ((Runnable) () -> {
            System.out.println(LocalTime.now() + ": Thread 1");
        }).run();
        ((Runnable) () -> {
            System.out.println(LocalTime.now() + " " + Thread.currentThread().getName());
        }).run();
        ((Runnable) () -> {
            System.out.println(LocalTime.now() + " " + Thread.currentThread().getName());
        }).run();
        System.out.println(Thread.currentThread().getName());
    }
}

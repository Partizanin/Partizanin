package hw3.threads;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 28.08.2014
 * Time:  12:21
 * To change this template use File|Setting|File Templates.
 */
public class Main {

    public static void main(String[] args) {
        Holder holder = Holder.getINSTANCE(2);
        Producer producer = new Producer(holder, "holder");
        Consumer consumer = new Consumer(holder, "holder");
        producer.start();
        consumer.start();

    }
}

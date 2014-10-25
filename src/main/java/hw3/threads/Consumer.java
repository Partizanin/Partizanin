package hw3.threads;

/**
 * Created with Intellij IDEA.
 * Project name: Курсы
 * User: Partizanin
 * Date: 19.05.2014
 * Time: 12:04
 * To change this template use File|Setting|File Templates.
 */
public class Consumer extends Thread {
    Holder q;
    int count = 5;


    Consumer(Holder q, String name) {
        this.q = q;
        if (q.count != 0) {
            this.count = q.count;
        }

        currentThread().setName(name);
    }

    public void run() {
        for (int i = 0; i < count; i++) {
            q.get();
        }
    }

}

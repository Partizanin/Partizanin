package hw3.threads;

/**
 * Created with Intellij IDEA.
 * Project name: Курсы
 * User: Partizanin
 * Date: 19.05.2014
 * Time: 11:51
 * To change this template use File|Setting|File Templates.
 */

/*Один поток генерирует числа второй выводит на экран используя промежуточное хранилище.

Классы задания:

hw3.threads.Producer
hw3.threads.Consumer
hw3.threads.Holder
*/
public class Producer extends Thread {
    Holder q;
    int count = 5;

    Producer(Holder q, String name) {
        this.q = q;
        if (q.count != 0) {
            this.count = q.count;
        }

        currentThread().setName(name);
    }

    public void run() {
        int i = 1;
        for (int j = 0; j < count; j++) {
            q.set(i++);
        }
    }


}

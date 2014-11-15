package myWork.other.education;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin.
 * User: Partizanin.
 * Date: 12.11.2014.
 * Time:  21:52.
 * To change this template use File|Setting|Editor|File and Code Templates.
 */
public class ThreadExtends extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

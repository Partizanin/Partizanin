package myWork.other;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 15.09.2014
 * Time:  12:42
 * To change this template use File|Setting|File Templates.
 */
public class Equals {
    public static void main(String[] args) {
        MyObj obj = new MyObj("12", 12);
        MyObj obj1 = new MyObj("11", 12);

        synchronized (args) {
            System.out.println(obj.getClass());
            System.out.println(obj.toString());
        }

    }
}

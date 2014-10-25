package week6.classwork.regiontable;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 8/14/13
 */
public class User {

    public static void main(String[] args) {


        int a = 12;
        int b = 22;
        int c = 33;

        System.out.println(min(a, b, c));

    }

    public static int min(int a, int b, int c) {
        int m;
        if (a < b && a < c)
            m = a;
        else
            m = b;
        if (c < a && c < b)
            m = c;
        else
            m = b;
        if (c < b && c < a)
            m = c;
        else
            m = b;
        return m;
    }
}

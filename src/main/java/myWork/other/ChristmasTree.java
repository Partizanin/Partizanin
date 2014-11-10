package myWork.other;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 28.10.2014
 * Time:  13:49
 * To change this template use File|Setting|File Templates.
 */
public class ChristmasTree {

    public static void main(String[] args) {
        triangle(12, "*");
    }

    private static void triangle(int n, String value) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i * 2 + 1; j++) {
                System.out.print(value);
            }
            System.out.println("");
        }
    }
}

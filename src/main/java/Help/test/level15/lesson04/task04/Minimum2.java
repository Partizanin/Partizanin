package Help.test.level15.lesson04.task04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 13.10.2014
 * Time:  11:23
 * To change this template use File|Setting|File Templates.
 */
public class Minimum2 {
    public static void main(String[] args) throws IOException {
        int i = 0;
        while (i < 4) {
            i++;
            String a, b;
            int cA, dB;
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("введите a и b, ");
            a = r.readLine();
            b = r.readLine();
            cA = Integer.parseInt(a);
            dB = Integer.parseInt(b);
            if (cA > dB) {
                System.out.println("минимум =  " + dB);
            } else if (cA < dB) {
                System.out.println("минимум =  " + cA);
            } else {
                System.out.println("минимум =  " + cA);
                //Напишите тут ваш код
    /* данные для тестирования:
    введите 1 и 2, минимум =  1
    введите 2 и 1, минимум =  1
    введите 1 и 1, минимум =  1
    введите -1 и -2, минимум =  -2
     */
            }
        }
    }
}

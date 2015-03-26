package myWork.other;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 30.08.2014
 * Time:  8:46
 * To change this template use File|Setting|File Templates.
 */
public class Main {
    public static void main(String[] args) throws Exception {
       /* int[] array = initializeArray();
        int max1 = max(array);
        int max2 = myMethod(array);
        System.out.println(max1);
        System.out.println(max2);*/

        BigDecimal usdUah = BigDecimal.valueOf(23.88);
        BigDecimal usdRub = BigDecimal.valueOf(51.98);
        BigDecimal one = BigDecimal.valueOf(1.0);
        BigDecimal temp = one.divide(usdUah, RoundingMode.valueOf(0));
        System.out.println(temp.doubleValue());
        BigDecimal uahRub = temp.multiply(usdRub);
        System.out.println(uahRub.doubleValue());
        System.out.println("");
    }

    public static int[] initializeArray() throws IOException {
        int[] mass = new int[20];
        for (int i = 0; i< mass.length;i++ ){
            mass[i]= i+1;
        }

        return mass;
    }

    public static int max(int[] array) {
        int m = array[0];
        for (int i =0; i<array.length;i++){
            if (array[i]>m)
                m = array[i];
        }

        return m;
    }
}



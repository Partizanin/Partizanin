package myWork.timeCalculator;

import junit.framework.TestCase;
import org.junit.Test;

public class MainWindow2Test extends TestCase {

    public static String summ(String getTime2) {

        int summ = 0;
        String value = "";
        String operation = "";
        String operation2 = "";
        boolean firstVal = false;

        for (int i = 0; i < getTime2.length(); i++) {

            if (!firstVal) {

                if (getTime2.charAt(i) == '+' || getTime2.charAt(i) == '-') {

                    operation += getTime2.charAt(i);
                    firstVal = true;
                    summ += Integer.parseInt(value);
                    value = "";
                } else {
                    value += getTime2.charAt(i);

                    if (!getTime2.contains("+") && !getTime2.contains("-") && i == getTime2.length() - 1) {
                        summ += Integer.parseInt(value);
                    }
                }
            } else {

                if (i == getTime2.length() - 1) {
                    if (operation.equals("+")) {
                        summ += Integer.parseInt(value += String.valueOf(getTime2.charAt(i)));
                    } else {
                        summ -= Integer.parseInt(value += String.valueOf(getTime2.charAt(i)));
                    }
                } else if (getTime2.charAt(i) == '+' || getTime2.charAt(i) == '-') {
                    operation2 += getTime2.charAt(i);

                    if (operation.equals("+")) {
                        summ += Integer.parseInt(value);
                    } else {
                        summ -= Integer.parseInt(value);
                    }


                    operation = operation2;
                    operation2 = "";
                    value = "";
                } else if (getTime2.charAt(i) != '+' && getTime2.charAt(i) != '-') {
                    value += getTime2.charAt(i);
                }

            }

        }

        return String.valueOf(summ);
    }


    @Test
    public void testTimePlusMinutes() throws Exception {

        assertEquals(summ("1+2+3+4+5+6+7+8+9+10"), "55");
        assertEquals(summ("1321+32146-222+884"), "34129");
        assertEquals(summ("32165+65165-6548+5"), "90787");
        assertEquals(summ("1"), "1");
        assertEquals(summ("12"), "12");
        assertEquals(summ("123"), "123");
        assertEquals(summ("1234"), "1234");
        assertEquals(summ("12345"), "12345");
        assertEquals(summ("12346"), "12346");
        assertEquals(summ("123467"), "123467");
        assertEquals(summ("1234678"), "1234678");
        assertEquals(summ("12346789"), "12346789");

    }
}
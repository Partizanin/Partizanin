package myWork.other;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 20.08.2014
 * Time:  11:14
 * To change this template use File|Setting|File Templates.
 */
public class NumberTest {

    public static void main(String[] args) {

        String value = "0,002";

        if (value.contains(".") || value.contains(",")) {

            if (value.contains(",")) {

                value = value.replaceAll(",", ".");
            }

            Double dnumber = Double.parseDouble(value);
            dnumber = dnumber * 2;
            String result = String.valueOf(dnumber);
            System.out.println(result);

        } else {
            Integer number = Integer.parseInt(value);
            number = number * 2;
            String result = String.valueOf(number);
            System.out.println(result);
        }


    }
}

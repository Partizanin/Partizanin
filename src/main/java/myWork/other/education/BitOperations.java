package myWork.other.education;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin.
 * User: Partizanin.
 * Date: 10.11.2014.
 * Time:  22:23.
 * To change this template use File|Setting|Editor|File and Code Templates.
 */
public class BitOperations {
    public static void main(String[] args) {

        int a = 30;

        a = a >>> 4;
        System.out.println(a);
    }

    public static void habrMethod() {
        int age, height, weight, combined, mask;
        age = 28; //00011100
        height = 185; //10111001
        weight = 80; //01010000
        combined = (age) | (height << 8) | (weight << 16); //00000000 01010000 10111001 00011100

        mask = 0b11111111;

        System.out.printf("Age: %d, height: %d, weight: %d",
                mask & combined,
                mask & combined >>> 8,
                mask & combined >>> 16);
//Age: 28, height: 185, weight: 80
    }
}

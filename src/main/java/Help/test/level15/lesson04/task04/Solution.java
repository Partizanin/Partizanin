package Help.test.level15.lesson04.task04;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 16.08.2014
 * Time:  15:26
 * To change this template use File|Setting|File Templates.
 */
public class Solution {
    public static void main(String[] args) {
        Man man = new Man();
        Woman woman = new Woman();

        Man.printName(man);
        Woman.printName(woman);
    }

    public static class Human {
        public static void printName(Human human) {
            System.out.println(human);
        }
    }

    public static class Man extends Human {
        public static void printName(Man man) {
            System.out.println(man);
        }
    }

    public static class Woman extends Human {
        public static void printName(Woman woman) {
            System.out.println(woman);
        }
    }
}

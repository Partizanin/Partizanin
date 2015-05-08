package myWork.other;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 30.08.2014
 * Time:  8:46
 * To change this template use File|Setting|File Templates.
 */

/* Переставить M первых строк в конец списка
Ввести с клавиатуры 2 числа N  и M.
Ввести N строк и заполнить ими список.
Переставить M первых строк в конец списка.
Вывести список на экран, каждое значение с новой строки.
*/
public class Main {
    public static void main(String[] args) {
        MyObj obj = new MyObj("Name", 12);
        obj.a = "1";

        System.out.println(obj.a);

    }

    public static Set<Cat> createCats() {
        Set<Cat> can = new HashSet<Cat>();
        can.add(new Cat("Push"));
        can.add(new Cat("Bars"));
        can.add(new Cat("Slen"));
        return can;
    }

    public static void printCats(Set<Cat> cats) {
        Iterator iterator = cats.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    public static class Cat {
        String name;

        public Cat(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Cat{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}



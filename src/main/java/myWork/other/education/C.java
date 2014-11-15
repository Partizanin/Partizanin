package myWork.other.education;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin.
 * User: Partizanin.
 * Date: 12.11.2014.
 * Time:  16:35.
 * To change this template use File|Setting|Editor|File and Code Templates.
 */
public class C extends A {

    @Override
    public void printSome() {
        System.out.println("Class C");
    }

    public static void main(String[] args) {
        A a = new A();
        a.printSome();
        a = new B();
        a.printSome();
        a = new C();
        a.printSome();
    }
}

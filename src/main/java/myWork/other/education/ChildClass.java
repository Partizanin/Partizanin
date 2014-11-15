package myWork.other.education;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin.
 * User: Partizanin.
 * Date: 12.11.2014.
 * Time:  16:16.
 * To change this template use File|Setting|Editor|File and Code Templates.
 */
public class ChildClass extends AbstractClass {
    @Override
    public void getProd() {
        System.out.println("get Product");
    }

    public static void main(String[] args) {
        ChildClass childClass = new ChildClass();

        childClass.getProd();
        System.out.println(childClass.getProd2());

    }
}

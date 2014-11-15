package myWork.other.education;

import java.lang.reflect.Method;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin.
 * User: Partizanin.
 * Date: 12.11.2014.
 * Time:  16:40.
 * To change this template use File|Setting|Editor|File and Code Templates.
 */
public class ChildClass2 extends AbstractClass {


    @Override
    public void getProd() {
        System.out.println(this.getClass().getName());
        Method[] declareMethods = this.getClass().getDeclaredMethods();
        Method[] methodNames = this.getClass().getMethods();
        System.out.println("\n---- all available methods ----\n");
        for (Method methodName : methodNames) {
            System.out.println(methodName.getName());
        }
        System.out.println("\n---- all declare methods ----\n");
        for (Method declareMethod : declareMethods) {
            System.out.println(declareMethod.getName());
        }

        System.out.println("\n---- SuperClass Name ----");

        Class c = this.getClass();

        Class superClass = c.getSuperclass();

        System.out.println(superClass.getName());

        Method[] declaredMethods = superClass.getDeclaredMethods();
        Method[] allMethods = superClass.getMethods();
        System.out.println("\n---- all declare methods ----\n");

        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
        }
        System.out.println("\n---- all available methods ----\n");
        for (Method allMethod : allMethods) {

            System.out.println(allMethod.getName());
        }
    }

    public static void main(String[] args) {
        ChildClass2 childClass2 = new ChildClass2();
        childClass2.getProd();
        System.out.println(childClass2.getProd2());
    }
}

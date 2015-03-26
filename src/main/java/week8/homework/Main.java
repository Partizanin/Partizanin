package week8.homework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import week8.homework.view.ConsoleControl;

import java.io.IOException;
import java.util.Locale;


/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 22.06.2014
 * Time: 15:45
 * To change this template use File|Setting|File Templates.
 */
public class Main {
    public static void main(String[] args) throws IOException {

        Locale.setDefault(Locale.ENGLISH);

        ApplicationContext context =
                new ClassPathXmlApplicationContext("notebooksdb/context-db.xml");

        ConsoleControl consoleControl = context.getBean("consoleControl", ConsoleControl.class);
        consoleControl.start();


    }
}

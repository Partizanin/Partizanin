package week9.homework.notebookSpringAnotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        new ClassPathXmlApplicationContext("notebooksAnotation/anotation-context-db.xml");


    }
}

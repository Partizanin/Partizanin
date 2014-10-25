package week9.homework.siteGrabber;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 02.07.2014
 * Time: 11:03
 * To change this template use File|Setting|File Templates.
 */
public class Main {
    public static void main(String[] args) {


        Locale.setDefault(Locale.ENGLISH);
        new ClassPathXmlApplicationContext("notebooksdb/site-anotation-context.xml");

    }

}

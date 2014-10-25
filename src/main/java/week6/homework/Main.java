package week6.homework;

import week6.homework.DAO.NotebookHibernateDaoImpl;
import week6.homework.Service.NotebookServiceImpl;
import week6.homework.View.ConsoleControle;


import java.io.IOException;
import java.util.Locale;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 10.06.2014
 * Time: 12:06
 * To change this template use File|Setting|File Templates.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.ENGLISH);
        NotebookHibernateDaoImpl notebookHibernateDao = new NotebookHibernateDaoImpl();
        NotebookServiceImpl notebookService = new NotebookServiceImpl(notebookHibernateDao);
        new ConsoleControle().startConsole(notebookService);
    }

}

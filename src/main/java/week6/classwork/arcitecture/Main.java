package week6.classwork.arcitecture;

import week6.classwork.arcitecture.DAO.NotebookHibernateDaoImpl;
import week6.classwork.arcitecture.Service.NotebookServiceImpl;
import week6.classwork.arcitecture.View.ConsoleControle;

import java.util.Locale;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 09.06.2014
 * Time: 10:41
 * To change this template use File|Setting|File Templates.
 */
public class Main {


    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        NotebookHibernateDaoImpl notebookHibernateDao = new NotebookHibernateDaoImpl();
        NotebookServiceImpl notebookService = new NotebookServiceImpl(notebookHibernateDao);
        new ConsoleControle().startConsole(notebookService);


    }
}
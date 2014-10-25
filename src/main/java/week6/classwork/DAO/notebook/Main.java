package week6.classwork.DAO.notebook;

import week6.classwork.notebooksdb.Notebook;

import java.util.Date;
import java.util.Locale;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 08.06.2014
 * Time: 17:11
 * To change this template use File|Setting|File Templates.
 */
public class Main {

    public static void main(String[] args) {
        NotebookHibernateDaoImpl nhdi = new NotebookHibernateDaoImpl();
        Locale.setDefault(Locale.ENGLISH);
        //long serialNumber, String brand, String model, Date creationDate, long price
        nhdi.create(new Notebook(123, "Mac", "123", new Date(System.currentTimeMillis()), 123));

    }
}

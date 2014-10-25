package week6.classwork.arcitecture.Service;


import week6.classwork.arcitecture.DAO.NotebookHibernateDaoImpl;
import week6.classwork.arcitecture.Domain.Notebook;

import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 08.06.2014
 * Time: 18:03
 * To change this template use File|Setting|File Templates.
 */
public class NotebookServiceImpl implements NotebookService {

    private NotebookHibernateDaoImpl instance;

    public NotebookServiceImpl(NotebookHibernateDaoImpl notebookHibernateDao) {

        instance = notebookHibernateDao;

    }


    @Override
    public void add(Notebook notebook) {
//long serialNumber, String brand, String model, Date creationDate, long price)

        instance.create(notebook);


    }

    @Override
    public List<Notebook> showAll() {

        List<Notebook> list = instance.findAll();

        return list;

    }
}

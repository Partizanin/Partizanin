package week8.homework.service.serviceimpl;

import week8.homework.domain.Notebook;
import week8.homework.DAO.daoimpl.NotebooksTypeDaoImpl;
import week8.homework.service.NotebooksTypeService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 18.06.2014
 * Time: 19:39
 * To change this template use File|Setting|File Templates.
 */
public class NotebooksTypeServiceimpl implements NotebooksTypeService {

    private NotebooksTypeDaoImpl notebooksTypeDao;

    public NotebooksTypeServiceimpl(NotebooksTypeDaoImpl notebooksTypeDao) {

        this.notebooksTypeDao = notebooksTypeDao;
    }

    @Override
    public void create(Notebook notebook) {

        notebooksTypeDao.create(notebook);
    }

    @Override
    public Notebook read(long id) {
        return notebooksTypeDao.read(id);
    }

    @Override
    public void update(Notebook notebook) {
        notebooksTypeDao.update(notebook);
    }

    @Override
    public void delete(Notebook notebook) {
        notebooksTypeDao.delete(notebook);
    }

    @Override
    public List<Notebook> showAll() {
        List<Notebook> list = new ArrayList<>();
        try {
            list = notebooksTypeDao.findAll();
        } catch (NullPointerException ignored) {

        }
        return list;
    }
}

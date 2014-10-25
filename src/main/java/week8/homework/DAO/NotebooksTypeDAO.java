package week8.homework.DAO;

import week8.homework.domain.Notebook;

import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 18.06.2014
 * Time: 19:06
 * To change this template use File|Setting|File Templates.
 */
public interface NotebooksTypeDAO {

    void create(Notebook notebook);

    Notebook read(long id);

    void update(Notebook notebook);

    void delete(Notebook notebook);

    List<Notebook> findAll();

}

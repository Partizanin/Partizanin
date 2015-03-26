package week6.classwork.DAO.notebook;

import week6.classwork.notebooksdb.Notebook;

import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 08.06.2014
 * Time: 16:37
 * To change this template use File|Setting|File Templates.
 */
public interface NotebookDAO {
    void create(Notebook notebook);

    Notebook read(Long id);

    void update(Notebook notebook);

    void delate(Notebook notebook);

    List<Notebook> findAll();

    List<Notebook> findByPrice(Long price);

    List findByBrand(String brand);


}

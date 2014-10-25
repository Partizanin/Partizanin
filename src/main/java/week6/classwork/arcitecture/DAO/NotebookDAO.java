package week6.classwork.arcitecture.DAO;

import week6.classwork.arcitecture.Domain.Notebook;

import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 08.06.2014
 * Time: 16:37
 * To change this template use File|Setting|File Templates.
 */
public interface NotebookDAO {
    void create(Notebook notebook);

    Notebook read(Long id);

    void update(Notebook notebook);

    void delete(Notebook notebook);

    List<Notebook> findAll();

    List<Notebook> findByPrice(Long price);

    List findByBrand(String brand);

}

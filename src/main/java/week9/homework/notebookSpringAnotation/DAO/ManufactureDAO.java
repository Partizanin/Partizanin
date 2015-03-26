package week9.homework.notebookSpringAnotation.DAO;

import week9.homework.notebookSpringAnotation.domain.Manufacturer;

import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 18.06.2014
 * Time: 19:31
 * To change this template use File|Setting|File Templates.
 */
public interface ManufactureDAO {
    void create(Manufacturer manufacturer);

    Manufacturer read(long id);

    void update(Manufacturer manufacturer);

    void delete(Manufacturer manufacturer);

    List<Manufacturer> findAll();
}

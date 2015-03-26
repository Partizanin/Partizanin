package week9.homework.notebookSpringAnotation.DAO;

import week9.homework.notebookSpringAnotation.domain.Warehouse;

import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 18.06.2014
 * Time: 19:21
 * To change this template use File|Setting|File Templates.
 */
public interface WarehouseDAO {

    void create(Warehouse warehouse);

    Warehouse read(long id);

    void update(Warehouse warehouse);

    void delete(Warehouse warehouse);

    List<Warehouse> findAll();
}

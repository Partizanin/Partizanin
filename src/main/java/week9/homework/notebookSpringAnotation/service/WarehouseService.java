package week9.homework.notebookSpringAnotation.service;

import week9.homework.notebookSpringAnotation.domain.Warehouse;

import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 18.06.2014
 * Time: 19:36
 * To change this template use File|Setting|File Templates.
 */
public interface WarehouseService {

    void add(Warehouse warehouse);

    Warehouse read(long id);

    void update(Warehouse warehouse);

    void delete(Warehouse warehouse);

    List<Warehouse> showAll();
}

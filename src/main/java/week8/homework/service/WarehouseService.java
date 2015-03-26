package week8.homework.service;

import week8.homework.domain.Notebook;
import week8.homework.domain.Warehouse;

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

    List<Notebook> getAllNotebooks();

    List<Notebook> showAllWichMore(int number);

    List<Notebook> showAllWichManufacturerName(String name);

    List<String> getAllNameProcessoreManufacturer();

}

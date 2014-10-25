package week8.homework.service.serviceimpl;

import week8.homework.domain.Notebook;
import week8.homework.domain.Warehouse;
import week8.homework.DAO.daoimpl.WarehouseDaoImpl;
import week8.homework.service.WarehouseService;

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
public class WarehouseServiceImpl implements WarehouseService {

    private WarehouseDaoImpl warehouseDao;

    public WarehouseServiceImpl(WarehouseDaoImpl warehouseDao) {

        this.warehouseDao = warehouseDao;
    }

    @Override
    public void add(Warehouse warehouse) {

        warehouseDao.create(warehouse);
    }

    @Override
    public Warehouse read(long id) {
        return warehouseDao.read(id);
    }

    @Override
    public void update(Warehouse warehouse) {
        warehouseDao.update(warehouse);
    }

    @Override
    public void delete(Warehouse warehouse) {
        warehouseDao.delete(warehouse);
    }

    @Override
    public List<Warehouse> showAll() {
        List<Warehouse> list = new ArrayList<>();
        try {
            list = warehouseDao.findAll();
        } catch (NullPointerException ignored) {

        }
        return list;
    }

    @Override
    public List<Notebook> getAllNotebooks() {
        List<Notebook> list = new ArrayList<>();
        try {
            list = warehouseDao.getAllNotebooks();
        } catch (NullPointerException ignored) {
            System.err.println("Notebooks not find");
        }
        return list;
    }

    @Override
    public List<Notebook> showAllWichMore(int number) {
        List<Notebook> list = new ArrayList<>();
        try {
            list = warehouseDao.showAllWichMore(number);
        } catch (NullPointerException ignored) {
            System.err.println("Notebooks not find");
        }
        return list;

    }

    @Override
    public List<Notebook> showAllWichManufacturerName(String name) {
        List<Notebook> list = new ArrayList<>();
        try {
            list = warehouseDao.showAllWichManufacturerName(name);
        } catch (NullPointerException ignored) {
            System.err.println("Notebooks not find");
        }
        return list;

    }

    @Override
    public List<String> getAllNameProcessoreManufacturer() {
        return null;
    }
}

package week9.homework.notebookSpringAnotation.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import week9.homework.notebookSpringAnotation.DAO.daoimpl.WarehouseDaoImpl;
import week9.homework.notebookSpringAnotation.domain.Warehouse;
import week9.homework.notebookSpringAnotation.service.WarehouseService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 18.06.2014
 * Time: 19:39
 * To change this template use File|Setting|File Templates.
 */
@Service
public class WarehouseServiceImpl implements WarehouseService {

    private WarehouseDaoImpl warehouseDao;

    @Autowired
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
        List<Warehouse> list = new ArrayList<Warehouse>();
        try {
            list = warehouseDao.findAll();
        } catch (NullPointerException ignored) {

        }
        return list;
    }
}

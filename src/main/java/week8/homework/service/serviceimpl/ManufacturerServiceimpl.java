package week8.homework.service.serviceimpl;


import week8.homework.DAO.daoimpl.ManufactureDaoImpl;
import week8.homework.domain.Manufacturer;
import week8.homework.service.ManufacturerService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 18.06.2014
 * Time: 19:38
 * To change this template use File|Setting|File Templates.
 */
public class ManufacturerServiceimpl implements ManufacturerService {

    private ManufactureDaoImpl manufactureDao;

    public ManufacturerServiceimpl(ManufactureDaoImpl manufactureDao) {

        this.manufactureDao = manufactureDao;

    }

    @Override
    public void create(Manufacturer manufacturer) {

        manufactureDao.create(manufacturer);
    }

    @Override
    public Manufacturer read(long id) {
        return manufactureDao.read(id);
    }

    @Override
    public void update(Manufacturer manufacturer) {

        manufactureDao.update(manufacturer);
    }

    @Override
    public void delete(Manufacturer manufacturer) {
        manufactureDao.delete(manufacturer);
    }

    @Override
    public List<Manufacturer> findAll() {
        List<Manufacturer> list = new ArrayList<>();
        try {
            list = manufactureDao.findAll();
        } catch (NullPointerException ignored) {

        }
        return list;

    }


}

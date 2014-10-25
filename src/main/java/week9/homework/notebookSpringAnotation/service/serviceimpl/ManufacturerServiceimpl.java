package week9.homework.notebookSpringAnotation.service.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import week9.homework.notebookSpringAnotation.DAO.daoimpl.ManufactureDaoImpl;
import week9.homework.notebookSpringAnotation.domain.Manufacturer;
import week9.homework.notebookSpringAnotation.service.ManufacturerService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 18.06.2014
 * Time: 19:38
 * To change this template use File|Setting|File Templates.
 */
@Service
public class ManufacturerServiceimpl implements ManufacturerService {

    private ManufactureDaoImpl manufactureDao;

    @Autowired
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

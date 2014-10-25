package week6.homework.Service;

import week6.homework.DAO.NotebookHibernateDaoImpl;
import week6.homework.domain.Notebook;

import java.util.Date;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 10.06.2014
 * Time: 13:25
 * To change this template use File|Setting|File Templates.
 */
public class NotebookServiceImpl implements NotebookService {

    private NotebookHibernateDaoImpl instance;

    public NotebookServiceImpl(NotebookHibernateDaoImpl notebookHibernateDao) {
        instance = notebookHibernateDao;
    }

    @Override
    public void add(Notebook notebook) {
        instance.create(notebook);
    }

    @Override
    public List<Notebook> showAll() {
        return instance.findAll();
    }

    @Override
    public void deleteBySerialnumber(long serialNumber) {
        instance.deleteBySerialnumber(serialNumber);
    }

    @Override
    public void changePriceBySerialNumber(long serialNumber, long price) {
        instance.changePriceBySerialNumber(serialNumber, price);
    }

    @Override
    public void changeSerialNumberAndManufactor(long serialNumber, long changedSerialNumber, String changeManufactor) {
        instance.changeSerialNumberAndManufactor(serialNumber, changedSerialNumber, changeManufactor);
    }

    @Override
    public List<Notebook> findByManufactor(String manufactor) {

        return instance.findByManufactor(manufactor);
    }

    @Override
    public void deleteByModel(String model) {

        instance.deleteByModel(model);
    }

    @Override
    public Notebook findByPriceAndDate(long price, Date date) {

        return instance.findByPriceAndDate(price, date);
    }

    @Override
    public List<Notebook> findByPriceRangeYearAndManufactor(long priceRange1, long priceRange2, Date date, String manufactor) {

        return instance.findByPriceRangeYearAndManufactor(priceRange1, priceRange2, date, manufactor);
    }

}

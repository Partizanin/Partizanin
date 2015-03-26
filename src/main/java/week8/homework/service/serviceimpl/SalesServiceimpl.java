package week8.homework.service.serviceimpl;

import week8.homework.domain.Sales;
import week8.homework.DAO.daoimpl.SalesDaoImpl;
import week8.homework.service.SalesService;

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
public class SalesServiceimpl implements SalesService {

    private SalesDaoImpl salesDao;

    public SalesServiceimpl(SalesDaoImpl salesDao) {
        this.salesDao = salesDao;
    }

    @Override
    public void add(Sales sales) {

        salesDao.create(sales);
    }

    @Override
    public Sales read(long id) {
        return salesDao.read(id);
    }

    @Override
    public void update(Sales sales) {
        salesDao.update(sales);
    }

    @Override
    public void delete(Sales sales) {
        salesDao.delete(sales);
    }

    @Override
    public List<Sales> showAll() {
        List<Sales> list = new ArrayList<>();
        try {
            list = salesDao.findAll();
        } catch (NullPointerException ignored) {

        }
        return list;

    }
}

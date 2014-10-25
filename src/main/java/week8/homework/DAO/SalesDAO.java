package week8.homework.DAO;

import week8.homework.domain.Sales;

import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 18.06.2014
 * Time: 19:21
 * To change this template use File|Setting|File Templates.
 */
public interface SalesDAO {

    void create(Sales sales);

    Sales read(long id);

    void update(Sales sales);

    void delete(Sales sales);

    List<Sales> findAll();
}

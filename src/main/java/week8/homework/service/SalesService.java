package week8.homework.service;

import week8.homework.domain.Sales;

import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 18.06.2014
 * Time: 19:36
 * To change this template use File|Setting|File Templates.
 */
public interface SalesService {

    void add(Sales sales);

    Sales read(long id);

    void update(Sales sales);

    void delete(Sales sales);

    List<Sales> showAll();
}

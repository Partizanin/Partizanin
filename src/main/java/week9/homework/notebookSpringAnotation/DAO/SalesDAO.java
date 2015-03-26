package week9.homework.notebookSpringAnotation.DAO;

import week9.homework.notebookSpringAnotation.domain.Sales;

import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
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

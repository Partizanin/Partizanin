package week6.homework.Service;

import week6.homework.domain.Notebook;

import java.util.Date;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 10.06.2014
 * Time: 13:07
 * To change this template use File|Setting|File Templates.
 */
public interface NotebookService {

    void add(Notebook notebook);

    List<Notebook> showAll();

    void deleteBySerialnumber(long serialNumber);

    void changePriceBySerialNumber(long serialNumber, long price);

    public void changeSerialNumberAndManufactor(long serialNumber, long changedSerialNumber, String changeManufactor);

    public List<Notebook> findByManufactor(String manufactor);

    public void deleteByModel(String model);

    public Notebook findByPriceAndDate(long price, Date date);

    public List<Notebook> findByPriceRangeYearAndManufactor(long priceRange1, long priceRange2, Date date, String manufactor);


}

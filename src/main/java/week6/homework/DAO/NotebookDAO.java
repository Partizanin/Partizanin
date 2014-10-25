package week6.homework.DAO;

import week6.homework.domain.Notebook;

import java.util.Date;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 10.06.2014
 * Time: 12:23
 * To change this template use File|Setting|File Templates.
 */

/*
* Добавить в приложение ноутбуков следующие функции:
- Удалить ноутбук по порядковому номеру
- Изменить цену ноутбука по порядковому номеру
- Изменить серийный номер и производителя
*
* Добавить в приложение ноутбуков следующие функции:
- Удалить ноутбуки по названию модели
- Получить ноутбуки по производителю
- Получить ноутбуки по цене и году выпуска
- Получить ноутбуки по цене в указанном диапазоне,
 меньше указанного года выпуска
 и указанного производителя*/
public interface NotebookDAO {

    void create(Notebook notebook);

    Notebook read(long id);

    void update(Notebook notebook);

    void delete(Notebook notebook);

    void deleteBySerialnumber(long serialNumber);

    void changePriceBySerialNumber(long serialNumber, long price);

    void changeSerialNumberAndManufactor(long serialNumber, long changedSerialNumber, String changeManufactor);

    void deleteByModel(String model);

    List<Notebook> findByManufactor(String manufactor);

    Notebook findByPriceAndDate(long price, Date date);

    List<Notebook> findByPriceRangeYearAndManufactor(long priceRange1, long priceRange2, Date date, String manufactor);

    List<Notebook> findAll();


}

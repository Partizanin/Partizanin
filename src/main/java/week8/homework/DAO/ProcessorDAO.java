package week8.homework.DAO;

import week8.homework.domain.Manufacturer;
import week8.homework.domain.Processor;

import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 18.06.2014
 * Time: 19:12
 * To change this template use File|Setting|File Templates.
 */
public interface ProcessorDAO {

    void create(Processor processor);

    Processor read(long id);

    void update(Processor processor);

    void delete(Processor processor);

    List<Processor> findAll();

    List<Manufacturer> findAllProcessorManufacturer();
}

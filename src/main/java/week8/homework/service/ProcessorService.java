package week8.homework.service;

import week8.homework.domain.Manufacturer;
import week8.homework.domain.Processor;

import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 18.06.2014
 * Time: 19:36
 * To change this template use File|Setting|File Templates.
 */
public interface ProcessorService {

    void create(Processor processor);

    Processor read(long id);

    void update(Processor processor);

    void delete(Processor processor);

    List<Processor> showAll();

    List<Manufacturer> findAllProcessorManufacturer();
}

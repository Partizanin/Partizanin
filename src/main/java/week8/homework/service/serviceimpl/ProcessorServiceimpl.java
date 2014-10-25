package week8.homework.service.serviceimpl;

import week8.homework.domain.Manufacturer;
import week8.homework.domain.Processor;
import week8.homework.DAO.daoimpl.ProcessorDaoImpl;
import week8.homework.service.ProcessorService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 18.06.2014
 * Time: 19:39
 * To change this template use File|Setting|File Templates.
 */
public class ProcessorServiceimpl implements ProcessorService {

    private ProcessorDaoImpl processorDao;

    public ProcessorServiceimpl(ProcessorDaoImpl processorDao) {

        this.processorDao = processorDao;
    }

    @Override
    public void create(Processor processor) {

        processorDao.create(processor);
    }

    @Override
    public Processor read(long id) {
        return processorDao.read(id);
    }

    @Override
    public void update(Processor processor) {
        processorDao.update(processor);
    }

    @Override
    public void delete(Processor processor) {
        processorDao.delete(processor);
    }

    @Override
    public List<Processor> showAll() {
        List<Processor> list = new ArrayList<>();
        try {
            list = processorDao.findAll();
        } catch (NullPointerException ignored) {

        }
        return list;
    }

    @Override
    public List<Manufacturer> findAllProcessorManufacturer() {
        return null;
    }
}

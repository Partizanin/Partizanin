package week9.homework.notebookSpringAnotation.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import week9.homework.notebookSpringAnotation.DAO.daoimpl.ProcessorDaoImpl;
import week9.homework.notebookSpringAnotation.domain.Processor;
import week9.homework.notebookSpringAnotation.service.ProcessorService;

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
@Service
public class ProcessorServiceimpl implements ProcessorService {

    private ProcessorDaoImpl processorDao;

    @Autowired
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
}

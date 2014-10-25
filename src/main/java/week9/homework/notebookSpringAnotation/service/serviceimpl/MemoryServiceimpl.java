package week9.homework.notebookSpringAnotation.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import week9.homework.notebookSpringAnotation.DAO.daoimpl.MemoryDaoImpl;
import week9.homework.notebookSpringAnotation.domain.Memory;
import week9.homework.notebookSpringAnotation.service.MemoryService;

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
@Service
public class MemoryServiceimpl implements MemoryService {

    private MemoryDaoImpl memoryDao;

    @Autowired
    public MemoryServiceimpl(MemoryDaoImpl memoryDao) {

        this.memoryDao = memoryDao;
    }

    @Override
    public void create(Memory memory) {

        memoryDao.create(memory);
    }

    @Override
    public Memory read(long id) {
        return memoryDao.read(id);
    }

    @Override
    public void update(Memory memory) {
        memoryDao.update(memory);
    }

    @Override
    public void delete(Memory memory) {
        memoryDao.delete(memory);
    }

    @Override
    public List<Memory> showAll() {
        List<Memory> list = new ArrayList<>();
        try {
            list = memoryDao.findAll();
        } catch (NullPointerException ignored) {

        }
        return list;

    }
}

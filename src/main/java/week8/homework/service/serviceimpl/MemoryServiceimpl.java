package week8.homework.service.serviceimpl;

import week8.homework.domain.Memory;
import week8.homework.DAO.daoimpl.MemoryDaoImpl;
import week8.homework.service.MemoryService;

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
public class MemoryServiceimpl implements MemoryService {

    private MemoryDaoImpl memoryDao;

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

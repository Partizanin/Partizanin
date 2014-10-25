package week8.homework.DAO;


import week8.homework.domain.Memory;

import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 18.06.2014
 * Time: 19:12
 * To change this template use File|Setting|File Templates.
 */
public interface MemoryDAO {

    void create(Memory memory);

    Memory read(long id);

    void update(Memory memory);

    void delete(Memory memory);

    List<Memory> findAll();
}

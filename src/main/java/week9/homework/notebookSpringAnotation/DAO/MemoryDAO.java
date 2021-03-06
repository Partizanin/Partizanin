package week9.homework.notebookSpringAnotation.DAO;


import week9.homework.notebookSpringAnotation.domain.Memory;

import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
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

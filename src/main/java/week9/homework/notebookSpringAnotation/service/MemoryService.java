package week9.homework.notebookSpringAnotation.service;

import week9.homework.notebookSpringAnotation.domain.Memory;

import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 18.06.2014
 * Time: 19:35
 * To change this template use File|Setting|File Templates.
 */
public interface MemoryService {

    void create(Memory memory);

    Memory read(long id);

    void update(Memory memory);

    void delete(Memory memory);

    List<Memory> showAll();
}

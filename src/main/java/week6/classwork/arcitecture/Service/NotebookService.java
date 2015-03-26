package week6.classwork.arcitecture.Service;


import week6.classwork.arcitecture.Domain.Notebook;

import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 08.06.2014
 * Time: 18:01
 * To change this template use File|Setting|File Templates.
 */
public interface NotebookService {

    void add(Notebook notebook);

    List<Notebook> showAll();
}

package week9.homework.notebookSpringAnotation.DAO.daoimpl;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import week9.homework.notebookSpringAnotation.DAO.ProcessorDAO;
import week9.homework.notebookSpringAnotation.domain.Processor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 18.06.2014
 * Time: 19:28
 * To change this template use File|Setting|File Templates.
 */

@Repository
public class ProcessorDaoImpl implements ProcessorDAO {

    private static Logger log = Logger.getLogger(ProcessorDaoImpl.class);

    private SessionFactory factory;

    @Autowired
    public ProcessorDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }


    @Override
    public void create(Processor processor) {
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            session.save(processor);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Transaction failed", e);
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }


    @Override
    public Processor read(long id) {
        Session session = factory.openSession();


        try {
            session.beginTransaction();

            return (Processor) session.get(Processor.class, id);
        } catch (HibernateException e) {
            log.error("Fetch error", e);
            e.printStackTrace();
        } finally {
            session.close();
        }

        return null;
    }

    @Override
    public void update(Processor processor) {

        Session session = factory.openSession();

        try {

            session.beginTransaction();

            session.update(processor);

            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Transaction failed", e);
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {

            session.close();
        }
    }

    @Override
    public void delete(Processor processor) {

        Session session = factory.openSession();

        try {

            session.beginTransaction();

            session.delete(processor);

            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("delete method", e);
            e.printStackTrace();
        } finally {

            session.close();
        }

    }

    @Override
    public List<Processor> findAll() {
        Session session = factory.openSession();
        List<Processor> list = new ArrayList<>();
        try {
            list = session.createCriteria(Processor.class).list();
        } catch (HibernateException e) {
            log.error("Fetch error", e);
            e.printStackTrace();
        } finally {
            session.close();
        }

        return list;
    }
}

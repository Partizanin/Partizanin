package week8.homework.DAO.daoimpl;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import week8.homework.domain.Memory;
import week8.homework.DAO.MemoryDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 18.06.2014
 * Time: 19:32
 * To change this template use File|Setting|File Templates.
 */
public class MemoryDaoImpl implements MemoryDAO {

    private static Logger log = Logger.getLogger(MemoryDaoImpl.class);
    private SessionFactory factory;

    public MemoryDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Memory memory) {
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            session.save(memory);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("create method", e);
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {

            session.close();

        }

    }

    @Override
    public Memory read(long id) {
        Session session = factory.openSession();

        try {
            session.beginTransaction();

            return (Memory) session.get(Memory.class, id);
        } catch (HibernateException e) {
            log.error("read method", e);
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public void update(Memory memory) {
        Session session = factory.openSession();

        try {

            session.beginTransaction();
            session.update(memory);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("update method", e);
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    @Override
    public void delete(Memory memory) {
        Session session = factory.openSession();

        try {

            session.beginTransaction();
            session.delete(memory);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("delete method", e);
            e.printStackTrace();
        } finally {

            session.close();
        }
    }

    @Override
    public List<Memory> findAll() {
        Session session = factory.openSession();
        List<Memory> list = new ArrayList<>();
        try {
            list = session.createCriteria(Memory.class).list();
        } catch (HibernateException e) {
            log.error("Fetch error", e);
            e.printStackTrace();
        } finally {
            session.close();
        }

        return list;
    }
}

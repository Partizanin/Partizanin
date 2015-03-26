package week8.homework.DAO.daoimpl;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import week8.homework.domain.Notebook;
import week8.homework.DAO.NotebooksTypeDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 18.06.2014
 * Time: 19:32
 * To change this template use File|Setting|File Templates.
 */
public class NotebooksTypeDaoImpl implements NotebooksTypeDAO {

    private static Logger log = Logger.getLogger(NotebooksTypeDaoImpl.class);
    private SessionFactory factory;

    public NotebooksTypeDaoImpl(SessionFactory factory) {

        this.factory = factory;
    }

    @Override
    public void create(Notebook notebook) {
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            session.save(notebook);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("crate method", e);
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {

            session.close();
        }
    }

    @Override
    public Notebook read(long id) {
        Session session = factory.openSession();

        try {
            return (Notebook) session.get(Notebook.class, id);
        } catch (HibernateException e) {
            log.error("Fetch error", e);
            e.printStackTrace();
        } finally {
            session.close();
        }

        return null;
    }

    @Override
    public void update(Notebook notebook) {
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            session.update(notebook);
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
    public void delete(Notebook notebook) {
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            session.delete(notebook);
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
    public List<Notebook> findAll() {
        Session session = factory.openSession();
        List<Notebook> list = new ArrayList<>();
        try {
            list = session.createCriteria(Notebook.class).list();
        } catch (HibernateException e) {
            log.error("Fetch error", e);
            e.printStackTrace();
        } finally {
            session.close();
        }

        return list;
    }

}


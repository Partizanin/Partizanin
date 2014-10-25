package week9.homework.notebookSpringAnotation.DAO.daoimpl;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import week9.homework.notebookSpringAnotation.DAO.WarehouseDAO;
import week9.homework.notebookSpringAnotation.domain.Warehouse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 18.06.2014
 * Time: 19:33
 * To change this template use File|Setting|File Templates.
 */
@Repository
public class WarehouseDaoImpl implements WarehouseDAO {

    private static Logger log = Logger.getLogger(WarehouseDaoImpl.class);


    private SessionFactory factory;

    @Autowired
    public WarehouseDaoImpl(SessionFactory factory) {

        this.factory = factory;
    }

    @Override
    public void create(Warehouse warehouse) {

        Session session = factory.openSession();

        try {
            session.beginTransaction();
            session.save(warehouse);
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
    public Warehouse read(long id) {
        Session session = factory.openSession();

        try {
            return (Warehouse) session.get(Warehouse.class, id);
        } catch (HibernateException e) {
            log.error("Fetch error", e);
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public void update(Warehouse warehouse) {

        Session session = factory.openSession();

        try {
            session.beginTransaction();
            session.update(warehouse);
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
    public void delete(Warehouse warehouse) {
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            session.delete(warehouse);
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
    public List<Warehouse> findAll() {
        Session session = factory.openSession();
        List<Warehouse> list = new ArrayList<>();
        try {
            list = session.createCriteria(Warehouse.class).list();
        } catch (HibernateException e) {
            log.error("Fetch error", e);
            e.printStackTrace();
        } finally {
            session.close();
        }

        return list;
    }
}
package week8.homework.DAO.daoimpl;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import week8.homework.domain.Notebook;
import week8.homework.domain.Warehouse;
import week8.homework.DAO.WarehouseDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 18.06.2014
 * Time: 19:33
 * To change this template use File|Setting|File Templates.
 */
public class WarehouseDaoImpl implements WarehouseDAO {

    private static Logger log = Logger.getLogger(WarehouseDaoImpl.class);


    private SessionFactory factory;

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

    @Override
    public List<Notebook> getAllNotebooks() {
        List<Notebook> notebookList = new ArrayList<>();
        Session session = factory.openSession();

        try {
            notebookList = session.createCriteria(Notebook.class).list();
        } catch (HibernateException e) {
            log.error("Fetch error", e);
            e.printStackTrace();
        } finally {
            session.close();
        }

        return notebookList;
    }

    @Override
    public List<Notebook> showAllWichMore(int number) {
        List<Notebook> notebookList = new ArrayList<>();
        Session session = factory.openSession();

        try {
            notebookList = session.createCriteria(Notebook.class)
                    .add(Restrictions.eq("number", number))
                    .list();
        } catch (HibernateException e) {
            log.error("Fetch error", e);
            e.printStackTrace();
        } finally {
            session.close();
        }

        return notebookList;
    }

    @Override
    public List<Notebook> showAllWichManufacturerName(String name) {
        List<Notebook> notebookList = new ArrayList<>();
        Session session = factory.openSession();
        try {
            notebookList = session.createQuery(" SELECT *\n" +
                    " FROM WAREHOUSE w\n" +
                    " JOIN NOTEBOOK n ON w.NOTEBOOK_NOTEBOOKS_ID = n.NOTEBOOKS_ID\n" +
                    " JOIN PROCESSOR p ON n.PROCESSOR_PROCESSOR_ID = p.PROCESSOR_ID\n" +
                    " JOIN MANUFACTURER m ON p.MANUFACTURER_MANUFACTURER_ID = p.MANUFACTURER_MANUFACTURER_ID\n" +
                    " WHERE m.MANUFACTURER_NAME = '" + name + "'")
                    .list();
        } catch (HibernateException e) {
            log.error("Fetch error", e);
            e.printStackTrace();
        } finally {
            session.close();
        }

        return notebookList;

    }

    @Override
    public List<String> getAllNameProcessoreManufacturer() {
        List<String> notebookList = new ArrayList<>();
        Session session = factory.openSession();
        try {
            /*notebookList = session.createQuery(" SELECT m.MANUFACTURER_NAME \n" +
                    " FROM WAREHOUSE w\n" +
                    " JOIN NOTEBOOK n ON w.NOTEBOOK_NOTEBOOKS_ID = n.NOTEBOOKS_ID\n" +
                    " JOIN PROCESSOR p ON n.PROCESSOR_PROCESSOR_ID = p.PROCESSOR_ID\n" +
                    " JOIN MANUFACTURER m ON m.MANUFACTURER_ID = p.MANUFACTURER_MANUFACTURER_ID")
                    .list();*/
        } catch (HibernateException e) {
            log.error("Fetch error", e);
            e.printStackTrace();
        } finally {
            session.close();
        }

        return notebookList;
    }


}
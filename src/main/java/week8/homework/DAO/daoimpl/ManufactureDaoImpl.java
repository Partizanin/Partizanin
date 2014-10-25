package week8.homework.DAO.daoimpl;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import week8.homework.domain.Manufacturer;
import week8.homework.DAO.ManufactureDAO;

import java.util.ArrayList;
import java.util.List;


/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 18.06.2014
 * Time: 19:31
 * To change this template use File|Setting|File Templates.
 */
public class ManufactureDaoImpl implements ManufactureDAO {

    private static Logger log = Logger.getLogger(ManufactureDaoImpl.class);

    private SessionFactory factory;

    public ManufactureDaoImpl(SessionFactory factory) {

        this.factory = factory;
    }

    @Override
    public void create(Manufacturer manufacturer) {

        Session session = factory.openSession();

        try {
            session.beginTransaction();
            session.save(manufacturer);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("crate method", e);
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Manufacturer read(long id) {
        Session session = factory.openSession();
        try {
            return (Manufacturer) session.get(Manufacturer.class, id);
        } catch (HibernateException e) {
            log.error("Fetch error", e);
            e.printStackTrace();
        } finally {
            session.close();
        }

        return null;
    }

    @Override
    public void update(Manufacturer manufacturer) {
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            session.update(manufacturer);
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
    public void delete(Manufacturer manufacturer) {
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            session.delete(manufacturer);
            session.getTransaction().commit();
        } catch (ConstraintViolationException e) {
            log.error("Transaction failed", e);
            System.err.println("you cant delete this object because it is still using");
        } catch (HibernateException e) {
            log.error("Transaction failed", e);
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Manufacturer> findAll() {
        Session session = factory.openSession();
        List<Manufacturer> list = new ArrayList<>();
        try {
            list = session.createCriteria(Manufacturer.class).list();
        } catch (HibernateException e) {
            log.error("Fetch error", e);
            e.printStackTrace();
        } finally {
            session.close();
        }

        return list;
    }


}

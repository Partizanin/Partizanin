package week6.classwork.arcitecture.DAO;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import week6.classwork.arcitecture.Domain.Notebook;


import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 08.06.2014
 * Time: 16:43
 * To change this template use File|Setting|File Templates.
 */
public class NotebookHibernateDaoImpl implements NotebookDAO {

    private static Logger log = Logger.getLogger(NotebookHibernateDaoImpl.class);

    @Override
    public void create(Notebook notebook) {
        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();
            session.save(notebook);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Transaction failed", e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Notebook read(Long id) {
        Session session = HibernateUtil.getSession();
        try {
            return (Notebook) session.get(Notebook.class, id);
        } catch (HibernateException e) {
            log.error("Fetch error", e);
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public void update(Notebook notebook) {

        Session session = HibernateUtil.getSession();

        try {

            session.beginTransaction();
            session.update(notebook);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

    }

    @Override
    public void delete(Notebook notebook) {

    }

    @Override
    public List<Notebook> findAll() {
        Session session = HibernateUtil.getSession();
        try {
//            session.createQuery("FROM Region").list();
            Criteria criteria = session.createCriteria(Notebook.class);//Создаем критерию
            criteria.add(Restrictions.or(
                    (Restrictions.eq("name", "22")),
                    (Restrictions.le("salary", 100))));

            return session.createCriteria(Notebook.class).list();
        } catch (HibernateException e) {
            log.error("Fetch error", e);
        } finally {
            session.close();
        }
        return null;
    }


    @Override
    public List<Notebook> findByPrice(Long price) {
        return null;
    }

    @Override
    public List<Notebook> findByBrand(String brand) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Notebook where brand = :name ");
        query.setParameter("name", brand);
        return query.list();
    }
}

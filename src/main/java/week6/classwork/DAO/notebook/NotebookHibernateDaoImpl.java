package week6.classwork.DAO.notebook;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import week6.classwork.DAO.HibernateUtil;

import org.apache.log4j.Logger;
import week6.classwork.notebooksdb.Notebook;
import week6.classwork.regiontable.Region;

import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
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
    public void delate(Notebook notebook) {

    }

    @Override
    public List<Notebook> findAll() {
        Session session = HibernateUtil.getSession();
        try {
//            session.createQuery("FROM Region").list();
            Criteria criteria = session.createCriteria(Region.class);//Создаем критерию
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

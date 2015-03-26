package week6.homework.DAO;


import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import week6.homework.domain.Notebook;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;


/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 10.06.2014
 * Time: 12:37
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
    public Notebook read(long id) {
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
        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();
            session.delete(notebook);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteBySerialnumber(long serialNumber) {
        Session session = HibernateUtil.getSession();
        try {
            Criteria criteria = session.createCriteria(Notebook.class);
            criteria.add(Restrictions.eq("NOTEBOOK_SERIAL", serialNumber));
            List<Notebook> list = session.createCriteria(Notebook.class).list();
            Notebook notebook = getNote(list, serialNumber);
            delete(notebook);
        } catch (HibernateException e) {
            e.printStackTrace();
            log.error("Fetch error in method deleteBySerialnumber " + e);
        } finally {
            session.close();
        }
    }

    @Override
    public void changePriceBySerialNumber(long serialNumber, long price) {

        Session session = HibernateUtil.getSession();
        try {
            Criteria criteria = session.createCriteria(Notebook.class);
            criteria.add(Restrictions.eq("NOTEBOOK_SERIAL", serialNumber));

            Notebook notebook = getNote(session.createCriteria(Notebook.class).list(), serialNumber);


            notebook.setPrice(price);

            update(notebook);
        } catch (HibernateException e) {
            log.error("Fetch error" + e);
        } finally {
            session.close();
        }

    }

    @Override
    public void changeSerialNumberAndManufactor(long serialNumber, long changedSerialNumber, String changeManufactor) {

        Session session = HibernateUtil.getSession();
        try {
            Criteria criteria = session.createCriteria(Notebook.class);
            criteria.add(Restrictions.eq("NOTEBOOK_SERIAL", serialNumber));

            Notebook notebook = getNote(session.createCriteria(Notebook.class).list(), serialNumber);


            notebook.setSerial(changedSerialNumber);
            notebook.setManufactor(changeManufactor);

            update(notebook);
        } catch (HibernateException e) {
            log.error("Fetch error" + e);
        } finally {
            session.close();
        }

    }

    @Override
    public List<Notebook> findByManufactor(String manufactor) {
        Session session = HibernateUtil.getSession();
        List<Notebook> notebook = new LinkedList<>();
        try {
            Criteria criteria = session.createCriteria(Notebook.class);
            criteria.add(Restrictions.eq("NOTEBOOK_MANUFACTOR", manufactor));

            notebook = getNoteboo(session.createCriteria(Notebook.class).list(), manufactor);

        } catch (HibernateException e) {
            log.error("Fetch error" + e);
        } finally {
            session.close();
        }

        return notebook;

    }

    @Override
    public void deleteByModel(String model) {
        Session session = HibernateUtil.getSession();
        try {
            Criteria criteria = session.createCriteria(Notebook.class);
            criteria.add(Restrictions.eq("NOTEBOOK_MODEL", model));

            Notebook notebook = getNotebook(session.createCriteria(Notebook.class).list(), model);

            delete(notebook);

        } catch (HibernateException e) {
            log.error("Fetch error" + e);
        } finally {
            session.close();
        }


    }

    @Override
    public Notebook findByPriceAndDate(long price, Date date) {
        //NOTEBOOK_DATE
        Session session = HibernateUtil.getSession();
        Notebook notebook = null;
        try {
            Criteria criteria = session.createCriteria(Notebook.class);
            criteria.add(Restrictions.eq("NOTEBOOK_DATE", date));

            notebook = getNotebook(session.createCriteria(Notebook.class).list(), price);

        } catch (HibernateException e) {
            log.error("Fetch error" + e);
        } finally {
            session.close();
        }

        return notebook;

    }

    @Override
    public List<Notebook> findByPriceRangeYearAndManufactor(long priceRange1, long priceRange2, Date date, String manufactor) {
//NOTEBOOK_DATE
        Session session = HibernateUtil.getSession();
        List<Notebook> notebook = null;
        try {
            Criteria criteria = session.createCriteria(Notebook.class);
            criteria.add(Restrictions.eq("NOTEBOOK_DATE", date));

            notebook = getByRangePriceAndDate(session.createCriteria(Notebook.class).list(), priceRange1, priceRange2, date, manufactor);

        } catch (HibernateException e) {
            log.error("Fetch error" + e);
        } finally {
            session.close();
        }

        return notebook;

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

    private Notebook getNote(List<Notebook> list, long serial) {

        Notebook returnNotebook = null;

        for (Notebook n : list) {

            if (n.getSerial() == serial) {
                returnNotebook = n;
                break;
            }
        }

        return returnNotebook;

    }

    private Notebook getNotebook(List<Notebook> list, long price) {
        Notebook returnNotebook = null;

        for (Notebook n : list) {

            if (n.getPrice() == price) {
                returnNotebook = n;
                break;
            }
        }

        return returnNotebook;

    }

    private List<Notebook> getNoteboo(List<Notebook> list, String manufacture) {

        List<Notebook> returnNotebook = new LinkedList<>();

        for (Notebook n : list) {

            if (n.getManufactor().equals(manufacture)) {
                returnNotebook.add(n);
            }
        }

        return returnNotebook;


    }

    private Notebook getNotebook(List<Notebook> list, String model) {

        Notebook returnNotebook = null;

        for (Notebook n : list) {

            if (n.getModel().equals(model)) {
                returnNotebook = n;
                break;
            }
        }

        return returnNotebook;


    }

    private List<Notebook> getByRangePriceAndDate(List<Notebook> list, long priceRange1, long priceRange2, Date date, String manufactor) {
        List<Notebook> list1 = new LinkedList<>();


        for (Notebook n : list) {

            if (n.getPrice() >= priceRange1 && n.getPrice() <= priceRange2) {
                if (n.getManufactor().equals(manufactor)) {
                    boolean b = n.getDate().getYear() <= date.getYear() &&
                            n.getDate().getMonth() <= date.getMonth()
                            && n.getDate().getDay() <= date.getDay();

                    if (n.getDate().getYear() <= date.getYear() &&
                            n.getDate().getMonth() <= date.getMonth()
                            && n.getDate().getDay() <= date.getDay()) {
                        list1.add(n);
                    }
                }

            }


        }

        return list1;

    }


}

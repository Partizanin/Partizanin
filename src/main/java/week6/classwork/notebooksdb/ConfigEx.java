package week6.classwork.notebooksdb;


import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import java.util.Date;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 5/11/13
 */
public class ConfigEx {
    private static Logger log = Logger.getLogger(ConfigEx.class);

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        AnnotationConfiguration configuration = new AnnotationConfiguration();
        SessionFactory factory = configuration.configure("notebooksdb/hibernate.cfg.xml").buildSessionFactory();
        log.info("Reference to SessionFactory " + factory);

        Session session = null;
        try {
            session = factory.openSession();

            session.beginTransaction();

            session.save(new Notebook(132, "Aser", "123", new Date(System.currentTimeMillis()), 123));


            //   Notebook notebook2 = notebook.getById(1);




            /*  try {
            session = HibernateUtil.getSessionFactory().openSession();
            user =  (User) session.get(User.class, user_id);
        } catch (Exception e) {*/


            session.getTransaction().commit();


            System.out.println();
        } catch (HibernateException e) {
            session.getTransaction().rollback();

            log.error("Open session failed", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        log.info(session);
    }
}

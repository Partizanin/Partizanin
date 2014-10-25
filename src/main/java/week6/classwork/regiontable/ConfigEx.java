package week6.classwork.regiontable;


import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

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
        SessionFactory factory = configuration.configure("/hibernate.cfg.xml").buildSessionFactory();
        log.info("Reference to SessionFactory " + factory);

        Session session = null;
        try {
            session = factory.openSession();

            Region region = (Region) session.get(Region.class, 4l);

            session.beginTransaction();

            Region region1 = new Region("Antarctica", 5l);
            region1.setName("Antarctica");
            session.save(region1);
            session.getTransaction().commit();

            // session.update(new Region());
            //   session.delete(new Region());

            System.out.println(region);
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

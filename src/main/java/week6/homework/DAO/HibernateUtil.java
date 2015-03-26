package week6.homework.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 10.06.2014
 * Time: 12:09
 * To change this template use File|Setting|File Templates.
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {

        try {
            return new AnnotationConfiguration().configure("homework/hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);

        }
    }

    private static SessionFactory getSessionFactory() {

        return sessionFactory;
    }

    public static Session getSession() {

        return sessionFactory.openSession();
    }

}

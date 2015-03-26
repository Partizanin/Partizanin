package week9.homework.siteGrabber.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import week9.homework.siteGrabber.domain.SiteTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 29.06.2014
 * Time: 17:28
 * To change this template use File|Setting|File Templates.
 */
@Component
public class SiteDaoImpl implements SiteDao {

    private static Logger log = Logger.getLogger(SiteDaoImpl.class);

    private SessionFactory factory;

    @Autowired
    public SiteDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void createContent(SiteTable site) {
        Session session = factory.openSession();
        try {
            site.setContent(searchLinks(site.getAddress()));
            session.beginTransaction();
            session.save(site);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("crate method", e);
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    private static String searchLinks(String siteUrl) {
        URL url = null;
        String result = "";
        try {
            url = new URL(siteUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            InputStream stream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            String line;

            while ((line = reader.readLine()) != null) {

                result += line;

            }
            List<String> link = new ArrayList<>();
            String[] words = result.split(" ");
            for (String word : words) {
                String str = "";
                if (word.contains("http://") || word.contains("https://")) {
                    char[] tempMass = word.toCharArray();
                    int linkPoint = word.indexOf("http://");

                    for (int j = linkPoint + 7; j <= tempMass.length - 1; j++) {
                        str += tempMass[j];
                    }
                    link.add(str);

                    if (link.size() > 3) {
                        break;
                    }
                }
            }
            int i = 0;
            for (String s : link) {
                result += s;
                System.out.println(s + "\n" + (i += 1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

}


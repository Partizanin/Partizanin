package week9.homework.siteGrabber.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import week9.homework.siteGrabber.dao.SiteDaoImpl;
import week9.homework.siteGrabber.domain.SiteTable;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 29.06.2014
 * Time: 17:30
 * To change this template use File|Setting|File Templates.
 */
@Service
public class SiteServiceImpl implements SiteService {

    private SiteDaoImpl siteDao;

    @Autowired
    public SiteServiceImpl(SiteDaoImpl siteDao) {
        this.siteDao = siteDao;
    }

    @Override
    public void createContent(SiteTable site) {

        siteDao.createContent(site);

    }

    @Override
    public String searchLinks(String siteContent) {
        String links = "";
        int count = 0;

        Scanner sc = new Scanner(siteContent);

        while (sc.hasNext()) {

            if (sc.next().equals("a href=\"")) {

                links += " " + sc.next();

                count++;

                if (count > 1) {
                    break;
                }
            }

        }

        System.out.println(links);
        return links;
    }

    @Override
    public void writeContentToFile(String siteContent) {
        Scanner sc;

        URL url = null;
        try {
            HttpURLConnection connection = null;
            url = new URL(siteContent);
            InputStream stream = connection.getInputStream();
            sc = new Scanner(new InputStreamReader(stream));
            String line = "";
            String links = "";
            while (sc.hasNext()) {

                links += sc.nextLine() + "\n";
                System.out.println(links);

            }
            System.out.print("Input path to file:");
            String path = sc.nextLine();//"e:\\FFOutput\\TestText.txt";
            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write(links);
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

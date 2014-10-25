package myWork;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 28.08.2014
 * Time:  21:30
 * To change this template use File|Setting|File Templates.
 */
public class SiteDownload {

    public static void main(String[] args) {
        HttpURLConnection con = null;
        String line = "";
        try {
            URL url = new URL("http://finance.i.ua/");
            con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "Cp1251"));//"Cp1251"
            StringBuffer sb = new StringBuffer();
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");

            }
            line += sb;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert con != null;
            con.disconnect();
        }

    }

    public String getSource() {
        HttpURLConnection con = null;
        String line = "";
        try {
            URL url = new URL("http://finance.i.ua/");
            con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "Cp1251"));//"Cp1251"
            StringBuffer sb = new StringBuffer();
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");

            }
            line += sb;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert con != null;
            con.disconnect();
        }
        return line;
    }
}

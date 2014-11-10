package myWork.javaChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 01.11.2014
 * Time:  13:14
 * To change this template use File|Setting|File Templates.
 */
public class GetIp {

    public static void main(String[] args) {
        GetIp ip = new GetIp();
        System.out.println(ip.getIp());
        System.out.println("Localhost: " + ip.getLocalIp());
    }


    public String getIp() {
        String ip = getIpFom2ipRu();

        if (ip == null || ip.equals("")) {
            ip = getIp2();
        }

        return ip;
    }

    private static String getIp2() {
        String result = null;
        try {
            BufferedReader reader = null;
            try {

                URL url = new URL("http://myip.by/");
                InputStream inputStream = null;
                inputStream = url.openStream();
                reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder allText = new StringBuilder();
                char[] buff = new char[1024];

                int count = 0;
                while ((count = reader.read(buff)) != -1) {
                    allText.append(buff, 0, count);
                }
// Строка содержащая IP имеет следующий вид
// <a href="whois.php?127.0.0.1">whois 127.0.0.1</a>
                Integer indStart = allText.indexOf("\">whois ");
                Integer indEnd = allText.indexOf("</a>", indStart);

                String ipAddress = allText.substring(indStart + 8, indEnd);
                if (ipAddress.split("\\.").length == 4) { // минимальная (неполная)
                    //проверка что выбранный текст является ip адресом.
                    result = ipAddress;
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public String getLocalIp() {
        try {
            InetAddress addr = InetAddress.getLocalHost();
            return addr.getHostAddress();
        } catch (java.net.UnknownHostException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String getIpFom2ipRu() {
        String site = "http://2ip.ru";
        String result = null;

        try {
            BufferedReader reader = null;

            try {

                URL url = new URL(site);
                InputStream inputStream = null;
                inputStream = url.openStream();

                reader = new BufferedReader(new InputStreamReader(inputStream));

                StringBuilder allText = new StringBuilder();

                char[] buff = new char[1024];

                int count = 0;

                while ((count = reader.read(buff)) != -1) {
                    allText.append(buff, 0, count);
                }

                int start = allText.indexOf("Ваш IP адрес:\n" +
                        "\t\t\t</span> <big id=\"d_clip_button\">");
                int end = allText.indexOf("</big>");
                return allText.substring(start + 49, end);
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }
}


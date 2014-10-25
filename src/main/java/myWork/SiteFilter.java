package myWork;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 28.08.2014
 * Time:  22:00
 * To change this template use File|Setting|File Templates.
 */
public class SiteFilter {

    private static SiteDownload sd = new SiteDownload();

    private static String siteSource = sd.getSource();


    private String buyUSD = buyUSD();
    private String sellUSD = sellUSD();

    private String buyRUB = buyRUB();
    private String sellRUB = sellRUB();

    private String buyEUR = buyEUR();
    private String sellEUR = sellEUR();

    public String getBuyUSD() {
        return buyUSD;
    }

    public String getSellUSD() {
        return sellUSD;
    }

    public String getBuyRUB() {
        return buyRUB;
    }

    public String getSellRUB() {
        return sellRUB;
    }

    public String getBuyEUR() {
        return buyEUR;
    }

    public String getSellEUR() {
        return sellEUR;
    }

    public static void main(String[] args) throws FileNotFoundException {

        String USD = getUSD();
        String EUR = getEUR();
        String RUB = getRUB();

        SiteFilter sf = new SiteFilter();
        String buyUSD = sf.getBuyUSD();
        String sellUSD = sf.getSellUSD();

        String buyRUB = sf.getBuyRUB();
        String sellRUB = sf.getSellRUB();

        String buyEUR = sf.getBuyEUR();
        String sellEUR = sf.getSellEUR();

        System.out.println("-----------------------EUR--------------------\n" + EUR);
        System.out.println("Sell EUR = " + sellEUR);
        System.out.println("Buy EUR = " + buyEUR);
        System.out.println("-------------------------------------------\n");

        System.out.println("-----------------------USD--------------------\n" + USD);
        System.out.println("Sell USD = " + sellUSD);
        System.out.println("Buy USD = " + buyUSD);
        System.out.println("-------------------------------------------\n");


        System.out.println("-----------------------RUB--------------------\n" + RUB);
        System.out.println("Sell RUB = " + sellRUB);
        System.out.println("Buy RUB = " + buyRUB);
        System.out.println("-------------------------------------------\n");


    }

    private static String sellRUB() {


        String line1 = "";
        String line2 = "";
        String line3 = "";


        double value1 = 0.0;
        double value2 = 0.0;
        double value3 = 0.0;

        Scanner sc = new Scanner(getRUB());

        if (sc.hasNext()) {
            sc.nextLine();
        }

        if (sc.hasNext()) {
            line1 = sc.nextLine();
        }
        if (sc.hasNext()) {
            line2 = sc.nextLine();
        }

        if (sc.hasNext()) {
            line3 = sc.nextLine();
        }


        int start = line1.indexOf("<big>") + 4;
        int finish = line1.indexOf("</big>");

        String temp = "";

        for (int i = 0; i < line1.length(); i++) {
            if (i > start && i < finish) {
                temp += line1.charAt(i);
            }
        }

        value1 = Double.valueOf(temp);

        temp = "";
        for (int i = 0; i < line2.length(); i++) {
            if (i > start && i < finish) {
                temp += line2.charAt(i);
            }
        }
        value2 = Double.valueOf(temp);

        temp = "";
        for (int i = 0; i < line3.length(); i++) {
            if (i > start && i < finish) {
                temp += line3.charAt(i);
            }
        }
        value3 = Double.valueOf(temp);


        BigDecimal res = ((BigDecimal.valueOf(value2))
                .add(BigDecimal.valueOf(value3))).divide(BigDecimal.valueOf(2.0), 4, RoundingMode.HALF_DOWN);

        return String.valueOf(res);
    }

    private static String buyRUB() {
        String line1 = "";

        double value1 = 0.0;

        Scanner sc = new Scanner(getRUB());

        if (sc.hasNext()) {
            line1 = sc.nextLine();
        }

        if (sc.hasNext()) {
            line1 = sc.nextLine();
        }

        int start = line1.indexOf("<big>") + 4;
        int finish = line1.indexOf("</big>");

        String temp = "";

        for (int i = 0; i < line1.length(); i++) {
            if (i > start && i < finish) {
                temp += line1.charAt(i);
            }
        }

        value1 = Double.valueOf(temp);

        return String.valueOf(value1);
    }


    private static String sellUSD() {


        String line1 = "";
        String line2 = "";
        String line3 = "";


        double value1 = 0.0;
        double value2 = 0.0;
        double value3 = 0.0;

        Scanner sc = new Scanner(getUSD());

        if (sc.hasNext()) {
            sc.nextLine();
        }

        if (sc.hasNext()) {
            line1 = sc.nextLine();
        }
        if (sc.hasNext()) {
            line2 = sc.nextLine();
        }

        if (sc.hasNext()) {
            line3 = sc.nextLine();
        }


        int start = line1.indexOf("<big>") + 4;
        int finish = line1.indexOf("</big>");

        String temp = "";

        for (int i = 0; i < line1.length(); i++) {
            if (i > start && i < finish) {
                temp += line1.charAt(i);
            }
        }

        value1 = Double.valueOf(temp);

        temp = "";
        for (int i = 0; i < line2.length(); i++) {
            if (i > start && i < finish) {
                temp += line2.charAt(i);
            }
        }
        value2 = Double.valueOf(temp);

        temp = "";
        for (int i = 0; i < line3.length(); i++) {
            if (i > start && i < finish) {
                temp += line3.charAt(i);
            }
        }
        value3 = Double.valueOf(temp);


        BigDecimal res = ((BigDecimal.valueOf(value2))
                .add(BigDecimal.valueOf(value3))).divide(BigDecimal.valueOf(2.0), 4, RoundingMode.HALF_DOWN);

        return String.valueOf(res);
    }

    private static String buyUSD() {
        String line1 = "";

        double value1 = 0.0;

        Scanner sc = new Scanner(getUSD());

        if (sc.hasNext()) {
            line1 = sc.nextLine();
        }

        if (sc.hasNext()) {
            line1 = sc.nextLine();
        }

        int start = line1.indexOf("<big>") + 4;
        int finish = line1.indexOf("</big>");

        String temp = "";

        for (int i = 0; i < line1.length(); i++) {
            if (i > start && i < finish) {
                temp += line1.charAt(i);
            }
        }

        value1 = Double.valueOf(temp);

        return String.valueOf(value1);
    }

    private static String sellEUR() {
        String line1 = "";
        String line2 = "";
        String line3 = "";


        double value1 = 0.0;
        double value2 = 0.0;
        double value3 = 0.0;

        Scanner sc = new Scanner(getEUR());

        if (sc.hasNext()) {
            sc.nextLine();
        }

        if (sc.hasNext()) {
            line1 = sc.nextLine();
        }
        if (sc.hasNext()) {
            line2 = sc.nextLine();
        }

        if (sc.hasNext()) {
            line3 = sc.nextLine();
        }


        int start = line1.indexOf("<big>") + 4;
        int finish = line1.indexOf("</big>");

        String temp = "";

        for (int i = 0; i < line1.length(); i++) {
            if (i > start && i < finish) {
                temp += line1.charAt(i);
            }
        }

        value1 = Double.valueOf(temp);

        temp = "";
        for (int i = 0; i < line2.length(); i++) {
            if (i > start && i < finish) {
                temp += line2.charAt(i);
            }
        }
        value2 = Double.valueOf(temp);

        temp = "";
        for (int i = 0; i < line3.length(); i++) {
            if (i > start && i < finish) {
                temp += line3.charAt(i);
            }
        }
        value3 = Double.valueOf(temp);


        BigDecimal res = ((BigDecimal.valueOf(value2))
                .add(BigDecimal.valueOf(value3))).divide(BigDecimal.valueOf(2.0), 4, RoundingMode.HALF_DOWN);

        return String.valueOf(res);

    }

    private static String buyEUR() {
        String line1 = "";

        double value1 = 0.0;

        Scanner sc = new Scanner(getEUR());

        if (sc.hasNext()) {
            line1 = sc.nextLine();
        }

        if (sc.hasNext()) {
            line1 = sc.nextLine();
        }

        int start = line1.indexOf("<big>") + 4;
        int finish = line1.indexOf("</big>");


        String temp = "";

        for (int i = 0; i < line1.length(); i++) {
            if (i > start && i < finish) {
                temp += line1.charAt(i);
            }
        }

        value1 = Double.valueOf(temp);

        return String.valueOf(value1);

    }


    private static String getUSD() {
        String result = getValues();
        String USD = "";

        int start = result.indexOf("<td class=\"align_left\"><b>USD</b></td>") + 37;
        int end = result.indexOf("</tr>\n" +
                "\t\t\t<tr>\n" +
                "\t\t\t\t<td class=\"align_left\"><b>EUR</b></td>");

        for (int i = 0; i < result.length(); i++) {

            if (i > start && i < end) {


                USD += result.charAt(i);
            }
        }
        return USD;
    }

    private static String getEUR() {
        String result = getValues();
        String EUR = "";

        int start = result.indexOf("<td class=\"align_left\"><b>EUR</b></td>") + 37;
        int end = result.indexOf("</tr>\n" +
                "\t\t\t<tr>\n" +
                "\t\t\t\t<td class=\"align_left\"><b>RUB</b></td>");

        for (int i = 0; i < result.length(); i++) {

            if (i > start && i < end) {


                EUR += result.charAt(i);
            }
        }
        return EUR;
    }

    private static String getRUB() {
        String result = getValues();
        String RUB = "";

        int start = result.indexOf("<td class=\"align_left\"><b>RUB</b></td>") + 37;
        int end = result.indexOf("</tr>\n" +
                "\t\t</table>");

        for (int i = 0; i < result.length(); i++) {

            if (i > start && i < end) {


                RUB += result.charAt(i);
            }
        }
        return RUB;
    }


    private static String getValues() {
        String siteSourceCode = siteSource;

        String result = " ";

        int start = siteSourceCode.indexOf("Средний курс валют");

        int end = siteSourceCode.indexOf("<td class=\"align_left\"><b>RUB</b></td>") + 450;

        for (int i = 0; i < siteSourceCode.length(); i++) {

            if (i > start && i < end) {

                result += siteSourceCode.charAt(i);
            }
        }

        return result;
    }

}

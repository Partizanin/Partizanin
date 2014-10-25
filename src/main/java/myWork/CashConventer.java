package myWork;

import java.math.BigDecimal;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 01.09.2014
 * Time:  10:36
 * To change this template use File|Setting|File Templates.
 */
public class CashConventer {

    private static SiteFilter sf = new SiteFilter();

    class UAH {

        public String buyUSD(String value) {
            return String.valueOf(BigDecimal.valueOf(Long.parseLong(value)).multiply(BigDecimal.valueOf(Long.parseLong(CashConventer.buyUSD()))));
        }

        public String buyRUB(String value) {
            return String.valueOf(BigDecimal.valueOf(Long.parseLong(value)).multiply(BigDecimal.valueOf(Long.parseLong(CashConventer.buyRUB()))));
        }

        public String buyEUR(String value) {
            return String.valueOf(BigDecimal.valueOf(Long.parseLong(value)).multiply(BigDecimal.valueOf(Long.parseLong(CashConventer.buyEUR()))));
        }

        public String sellUSD(String value) {
            return String.valueOf(BigDecimal.valueOf(Long.parseLong(value)).multiply(BigDecimal.valueOf(Long.parseLong(CashConventer.sellUSD()))));
        }

        public String sellRUB(String value) {
            return String.valueOf(BigDecimal.valueOf(Long.parseLong(value)).multiply(BigDecimal.valueOf(Long.parseLong(CashConventer.sellRUB()))));

        }

        public String sellEUR(String value) {
            return String.valueOf(BigDecimal.valueOf(Long.parseLong(value)).multiply(BigDecimal.valueOf(Long.parseLong(CashConventer.sellEUR()))));
        }
    }

    class EUR {

        public String buyUAH() {
            return CashConventer.buyEUR();
        }

        public String buyUSD() {
            return devide(CashConventer.buyEUR(), CashConventer.buyUSD());
        }

        public String buyRUB() {
            return devide(CashConventer.buyEUR(), CashConventer.buyRUB());
        }

        public String sellUAH() {
            return CashConventer.sellEUR();
        }

        public String sellUSD() {
            return devide(CashConventer.sellEUR(), CashConventer.sellUSD());
        }

        public String sellRUB() {
            return devide(CashConventer.sellEUR(), CashConventer.sellRUB());
        }
    }

    class RUB {

        public String buyUAH() {
            return CashConventer.buyEUR();
        }

        public String buyUSD() {
            return devide(CashConventer.buyEUR(), CashConventer.buyUSD());
        }

        public String buyRUB() {
            return devide(CashConventer.buyEUR(), CashConventer.buyRUB());
        }

        public String sellUAH() {
            return CashConventer.sellEUR();
        }

        public String sellUSD() {
            return devide(CashConventer.sellEUR(), CashConventer.sellUSD());
        }

        public String sellRUB() {
            return devide(CashConventer.sellEUR(), CashConventer.sellRUB());
        }
    }

    class USD {

        public String buyUAH() {
            return CashConventer.buyEUR();
        }

        public String buyUSD() {
            return devide(CashConventer.buyEUR(), CashConventer.buyUSD());
        }

        public String buyRUB() {
            return devide(CashConventer.buyEUR(), CashConventer.buyRUB());
        }

        public String sellUAH() {
            return CashConventer.sellEUR();
        }

        public String sellUSD() {
            return devide(CashConventer.sellEUR(), CashConventer.sellUSD());
        }

        public String sellRUB() {
            return devide(CashConventer.sellEUR(), CashConventer.sellRUB());
        }
    }


    public static String devide(String a, String b) {


        return String.valueOf(BigDecimal.valueOf(Long.parseLong(a)).divide(BigDecimal.valueOf(Long.parseLong(b))));

    }

    public static String buyUSD() {

        return sf.getBuyUSD();
    }

    public static String buyRUB() {

        return sf.getBuyUSD();
    }

    public static String buyEUR() {

        return sf.getBuyUSD();
    }

    public static String sellEUR() {

        return sf.getSellEUR();
    }

    public static String sellRUB() {

        return sf.getSellRUB();
    }

    public static String sellUSD() {

        return sf.getSellRUB();
    }

}

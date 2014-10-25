package week5.classWork;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

/**
 * Created with Intellij IDEA.
 * Project name: Курсы
 * User: Partizanin
 * Date: 01.06.2014
 * Time: 15:43
 * To change this template use File|Setting|File Templates.
 */
public class Connection {
    public java.sql.Connection getConnection() {
        Locale.setDefault(Locale.ENGLISH);

        System.out.println("Application started...");
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found");
            e.printStackTrace();
            return null;
        }
        System.out.println("JDBC driver is loaded!");

        java.sql.Connection conn = null;
        String url = "jdbc:oracle:thin:@localhost:1521:XE";

        try {
            conn = DriverManager.getConnection(url, "hr", "hr");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}


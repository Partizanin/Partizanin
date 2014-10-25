package week5.classWork;


import javax.swing.*;
import java.sql.Connection;
import java.sql.*;
import java.util.Locale;

/**
 * Created with Intellij IDEA.
 * Project name: Курсы
 * User: Partizanin
 * Date: 01.06.2014
 * Time: 15:42
 * To change this template use File|Setting|File Templates.
 */
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        System.out.println("Application started...");
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found");
            e.printStackTrace();
            return;
        }
        System.out.println("JDBC driver is loaded!");

        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        try {
            conn = DriverManager.getConnection(url, "hr", "hr");
            System.out.println("Connection established!");
            String name = JOptionPane.showInputDialog(null, "Введите имя пользователя");
            statement = conn.createStatement();
            resultSet = statement.executeQuery(
                    "SELECT * FROM employees WHERE first_name = '" + name + "'");

            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                String firstName = resultSet.getString("FIRST_NAME");
                String lastName = resultSet.getString("LAST_NAME");
                System.out.printf("%d     %s    %s", id, firstName, lastName);
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }
}

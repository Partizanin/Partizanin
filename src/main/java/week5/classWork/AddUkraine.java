package week5.classWork;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 01.06.2014
 * Time: 16:29
 * To change this template use File|Setting|File Templates.
 */
public class AddUkraine {

    public static void main(String[] args) {

        java.sql.Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = new Connection().getConnection();
            System.out.println("Connection established!");
            String country = JOptionPane.showInputDialog(null, "Введите страну");
            statement = connection.createStatement();
            int n = statement.executeUpdate("INSERT INTO countries c(c.country_id,country_name,region_id)" +
                    "VALUES ('UA', '" + country + "', 1)");
            System.out.println(n);

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
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                }
            }

        }
    }
}

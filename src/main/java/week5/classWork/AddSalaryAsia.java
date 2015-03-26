package week5.classWork;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 01.06.2014
 * Time: 17:01
 * To change this template use File|Setting|File Templates.
 */
public class AddSalaryAsia {

    public static void main(String[] args) throws SQLException {

        java.sql.Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = new Connection().getConnection();
            System.out.println("Connection established!");
            String region = "Europe";//JOptionPane.showInputDialog(null,"Input region");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * " +
                    "FROM employees e JOIN departments d ON e.department_id= d.department_id" +
                    " JOIN locations l ON d.location_id= l.location_id " +
                    " JOIN countries c ON c.country_id= l.country_id " +
                    " JOIN regions r ON r.region_id= c.region_id " +
                    "WHERE r.region_name='" + region + "'");

            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                int salary = resultSet.getInt("salary");
                System.out.println(firstName + "Salry = " + salary + "+" + "100");
                int n = statement.executeUpdate("UPDATE employees " +
                        "SET salary = salary + 100");

                System.out.println(n);
                System.out.println(firstName + " " + salary);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
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

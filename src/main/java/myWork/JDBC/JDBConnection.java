package myWork.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 09.09.2014
 * Time:  16:30
 * To change this template use File|Setting|File Templates.
 */
public class JDBConnection {

    public static void main(String[] args) {

        /*oracle.jdbc.driver.OracleDriver
        *jdbc:oracle:thin:@localhost:1521:XE
         *  */

        Connection con = null;
        ResultSet resultSet;
        Statement statement;
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String driver = "oracle.jdbc.driver.OracleDriver";
        String login = "hr";
        String password = "hr";

        System.out.println("Application started...");

        wait(1000);

        try {
            Class.forName(driver);
            System.out.println("Driver is loaded");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        wait(1000);

        try {
            con = DriverManager.getConnection(url, login, password);
            System.out.println("Connection complete!\n");

            statement = con.createStatement();

            resultSet = statement.executeQuery(
                    "SELECT *" +
                            "FROM EMPLOYEES e");

            int count = 1;
            wait(1000);
            String employees = "";
            while (resultSet.next()) {

                employees += (count + ") " + resultSet.getString("FIRST_NAME") + " " + resultSet.getString("LAST_NAME") + " " + resultSet.getString("SALARY") + "$\n");
                count++;
            }

            System.out.println("Find " + count + " employees!\n");
            wait(1000);
            System.out.println(employees);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void wait(int milisecond) {

        try {
            Thread.currentThread();
            Thread.sleep(milisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void getEuropeans() {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection;
        JDBConnection jdbc = new JDBConnection();

        connection = jdbc.getConnection();


        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(
                    "SELECT e.employee_id, e.first_name, e.last_name, e.salary,r.region_name\n" +
                            "FROM employees e " +
                            "JOIN departments d ON e.department_id = d.department_id " +
                            "JOIN locations l ON d.location_id = l.location_id " +
                            "JOIN countries c ON l.country_id = c.country_id " +
                            "JOIN regions r ON c.region_id = r.region_id " +
                            "WHERE region_name = 'Europe' ");
            int count = 1;
            ArrayList<String> sn = new ArrayList<String>();
            while (resultSet.next()) {

                sn.add(count + ") " + resultSet.getString("FIRST_NAME") + " " +
                        "" + resultSet.getString("LAST_NAME") + " " + resultSet.getString("region_name"));

                count++;

            }

            sn.sort(Comparator.<String>naturalOrder());

            for (int i = 0; i < sn.size(); i++) {

                System.out.println(i + 1 + ") " + sn.get(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();

            System.out.println("Connection failed");
        }
    }

    public static void getEmployees() {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection;
        JDBConnection jdbc = new JDBConnection();

        connection = jdbc.getConnection();


        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(
                    "SELECT e.FIRST_NAME,e.LAST_NAME FROM EMPLOYEES e ");
            int count = 1;
            ArrayList<String> sn = new ArrayList<String>();
            while (resultSet.next()) {

                sn.add(resultSet.getString("FIRST_NAME") + " " + resultSet.getString("LAST_NAME"));

            }

            sn.sort(Comparator.<String>naturalOrder());

            for (int i = 0; i < sn.size(); i++) {

                System.out.println(i + 1 + ") " + sn.get(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();

            System.out.println("Connection failed");
        }


    }

    public static void prepareStatment() {

        //  Database credentials

        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String driver = "oracle.jdbc.driver.OracleDriver";
        String login = "hr";
        String password = "hr";

        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(url, login, password);

            // Let us select all the records and display them.
            String sql = "SELECT id, first, last, age FROM Employees";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String first = rs.getString("first");
                String last = rs.getString("last");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", Age: " + age);
                System.out.print(", First: " + first);
                System.out.println(", Last: " + last);
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
        //end main
//end JDBCExample
    }

    public Connection getConnection() {
        Connection conn = null;
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


        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        try {
            conn = DriverManager.getConnection(url, "hr", "hr");
            System.out.println("Connection is compleate!");
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }

        return conn;
    }
}

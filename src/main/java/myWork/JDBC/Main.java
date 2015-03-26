package myWork.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 09.09.2014
 * Time:  17:36
 * To change this template use File|Setting|File Templates.
 */
public class Main {

    public static void main(String[] args) {
        JDBConnection connection = new JDBConnection();
        Connection conn = connection.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;

       /* String region = JOptionPane.showInputDialog(null, "Input Region");*/
        System.out.println("ResultSet Start!");
        try {
            statement = conn.createStatement();
/*select e.FIRST_NAME,r.region_name
from employees e
join DEPARTMENTS d on e.DEPARTMENT_ID = d.DEPARTMENT_ID
join LOCATIONS l on d.LOCATION_ID = l.LOCATION_ID
join countries co on l.COUNTRY_ID = co.COUNTRY_ID
join REGIONS r on co.REGION_ID = r.REGION_ID
where r.region_name = 'Europe';*/
            resultSet = statement.executeQuery("SELECT * \n" +
                    "FROM employees e \n" +
                    "join DEPARTMENTS d on e.DEPARTMENT_ID = d.DEPARTMENT_ID\n" +
                    "join LOCATIONS l on d.LOCATION_ID = l.LOCATION_ID\n" +
                    "join countries co on l.COUNTRY_ID = co.COUNTRY_ID\n" +
                    "join REGIONS r on co.REGION_ID = r.REGION_ID\n" +
                    "where r.region_name = 'Europe'");



     /*   resultSet = statement.executeQuery("SELECT * FROM employees e JOIN departments d ON e.department_id= d.department_id"+
                " JOIN locations l ON d.location_id= l.location_id "+
                " JOIN countries c ON c.country_id= l.country_id "+
                " JOIN regions r ON r.region_id= c.region_id WHERE r.region_name='"+region+"'");*/
            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                int salary = resultSet.getInt("salary");
                String regionS = resultSet.getString("region_name");
                System.out.println(salary + " " + firstName + " " + regionS);
                //int n = statement.executeUpdate("INSERT INTO employees (salary) VALUES ('salary' + 100)");
                //System.out.println(firstName + " " + salary);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

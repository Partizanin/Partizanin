package week5.classWork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 31.05.2014
 * Time: 18:33
 * To change this template use File|Setting|File Templates.
 */
public class JDBC {

    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String path = "C:\\Program Files\\Java\\OJDBC14";
        String url = "jdbc:oracle:thin:@localhost:1521:EX";
        Connection conn = DriverManager.getConnection(url, "hr", "hr");
        System.out.println(conn);
    }
}

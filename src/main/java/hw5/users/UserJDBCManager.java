package hw5.users;

import week5.classWork.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 05.06.2014
 * Time: 18:08
 * To change this template use File|Setting|File Templates.
 */

public class UserJDBCManager {


    UserJDBCManager() {
        connection();
    }


    private java.sql.Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    private void connection() {

        connection = new Connection().getConnection();
        System.out.println("Connection established!");
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int create(User user) throws SQLException {

        Locale.setDefault(Locale.ENGLISH);
        SimpleDateFormat format = new SimpleDateFormat("dd-MMMMM-YYYY");
        String date = (format.format(user.getDate()));

        return statement.executeUpdate("INSERT INTO USERS (USERS_ID,FIRST_NAME,PASSWORD,CREATION_DATE) " +
                "VALUES ('" + user.getId() + "','" + user.getName() + "','" + user.getPassword() + "','" + date + "')");

    }

    public void closeConnection() {
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

    public List<User> findAll() {
        ArrayList<User> list = new ArrayList<>();

        try {
            resultSet = statement.executeQuery(
                    "SELECT * " +
                            "FROM users ");


            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                int userId = (int) id;
                String firstName = resultSet.getString("FIRST_NAME");
                String password = resultSet.getString("Password");
                Date date = resultSet.getDate("CREATION_DATE");

                list.add(new User(userId, firstName, password, date));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}

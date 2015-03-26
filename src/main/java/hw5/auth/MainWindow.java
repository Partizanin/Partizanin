package hw5.auth;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 06.06.2014
 * Time: 15:20
 * To change this template use File|Setting|File Templates.
 */

/*
Классы задания:
hw5.auth.MainWindow
hw5.auth.UserJDBCManager
hw5.auth.User
* */
public class MainWindow {

    public static void main(String[] args) throws IOException, SQLException {
        new MainWindow().start();
    }

    private UserJDBCManager userJDBCManager = new UserJDBCManager();

    public void start() throws SQLException, IOException {
        Scanner sc = new Scanner(System.in);

        int select = 0;

        String menu = "\n1 - Аутентифікація\n2 - Вийти";

        for (; ; ) {
            System.out.println(menu);
            try {
                select = sc.nextInt();
            } catch (InputMismatchException e) {

                System.err.println("Ви ввели не число!!!");
            }

            if (select == 1) {

                if (auth()) {
                    System.err.println("open access\n");
                    List<User> list = userJDBCManager.findAll();
                    for (User aList : list) {

                        System.out.println(aList);
                    }
                } else {

                    System.err.println("Неправильный логин или пароль");
                }


            } else if (select == 2) {
                userJDBCManager.closeConnection();
                System.exit(0);
            } else {

                System.out.println("Ви ввели не вірне значення");
            }
        }
    }


    private boolean auth() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<User> list = userJDBCManager.findAll();


        System.out.println("Введіть Ім'я: ");
        String name = reader.readLine();

        System.out.println("Введіть пароль: ");
        String password = reader.readLine();

        boolean isEquals = false;

        for (User user : list) {

            if (user.getName().equals(name) && user.getPassword().equals(password)) {

                isEquals = true;
            }
        }

        return isEquals;
    }

}

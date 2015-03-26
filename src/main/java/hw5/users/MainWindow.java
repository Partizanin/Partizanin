package hw5.users;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 05.06.2014
 * Time: 18:07
 * To change this template use File|Setting|File Templates.
 */

/*
Написать приложение, позволяющее добавлять нового
 пользователя и просматривать список существующих пользователей.
 Структура таблицы (id, имя, пароль, дата).

Классы задания:
MainWindow
UserJDBCManager
User
* */
public class MainWindow {


    public static void main(String[] args) throws SQLException, IOException {


        new MainWindow().start();
    }


    private UserJDBCManager userJDBCManager = new UserJDBCManager();

    public void start() throws SQLException, IOException {
        Scanner sc = new Scanner(System.in);

        int select = 0;

        String menu = "\n1 - Створити користувача\n2 - Вивести всіх користувачів\n3 - Вийти";

        for (; ; ) {
            System.out.println(menu);
            try {
                select = sc.nextInt();
            } catch (InputMismatchException e) {

                System.err.println("Ви ввели не число!!!");
            }

            if (select == 1) {

                userJDBCManager.create(createUser());


            } else if (select == 2) {

                List<User> list = userJDBCManager.findAll();

                for (User user : list) {

                    System.out.println(user);
                }

            } else if (select == 3) {
                userJDBCManager.closeConnection();
                System.exit(0);
            } else {

                System.out.println("Ви ввели не вірне значення");
            }
        }
    }

    private User createUser() throws IOException {
        BufferedReader readr = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введыть значення id : ");
        int id = 0;

        for (; ; ) {
            boolean iSbreak = false;

            while (!chekID(id) || id == 0) {


                try {

                    id = Integer.parseInt(readr.readLine());

                    iSbreak = true;
                } catch (NumberFormatException e) {

                    System.err.println("Ви ввели не число спробуйте ще раз!!!");

                    iSbreak = false;
                }


            }

            if (iSbreak) {
                break;
            }

        }

        System.out.println("Введыть значення name : ");
        String name = readr.readLine();
        System.out.println("Введыть значення password : ");
        String password = readr.readLine();
        Date date = new Date(System.currentTimeMillis());

        return new User(id, name, password, date);
    }

    private boolean chekID(int id) {
        List<User> list = userJDBCManager.findAll();
        for (User user : list) {
            if (id == user.getId()) {
                System.err.println("Такий ID  вже існує введіть будьласка інший");
                return false;
            }
        }
        return true;
    }

}

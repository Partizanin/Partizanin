package hw2.authentication;

import java.util.*;

/**
 * Created with Intellij IDEA.
 * Project name: Курсы
 * User: Partizanin
 * Date: 13.05.2014
 * Time: 14:26
 * To change this template use File|Setting|File Templates.
 */
/*
Написать класс аутентификации пользователя по логину и паролю, с методами:
	- boolean authenticate() - ввод логина и пароля + проверка
	- boolean authenticate(String login, String pass)
	- add(String login, String pass)
	- remove(String login)

Класс задания hw2.authentication.Auth
*/

public class Auth {

    Map<String, String> map = new HashMap<>();
    Scanner sc = new Scanner(System.in);


    public boolean authenticate() {
        System.out.println("input login: ");
        String login = sc.next();
        System.out.println("Input password: ");
        String password = sc.next();

        Iterator<Map.Entry<String, String>> itr;
        ArrayList<String> listOFKeys = new ArrayList<>(map.size());
        ArrayList<String> listOFValues = new ArrayList<>(map.size());

        itr = map.entrySet().iterator();

        while (itr.hasNext()) {

            listOFKeys.add(itr.next().getKey());
        }

        itr = map.entrySet().iterator();

        while (itr.hasNext()) {

            listOFValues.add(itr.next().getValue());
        }


        for (int i = 0; i < listOFKeys.size(); i++) {

            if (listOFKeys.get(i).equals(login) && listOFValues.get(i).equals(password)) {

                return true;
            }
        }

        return false;
    }


    boolean authenticate(String login, String pass) {

        Iterator<Map.Entry<String, String>> itr;
        ArrayList<String> listOFKeys = new ArrayList<>(map.size());
        ArrayList<String> listOFValues = new ArrayList<>(map.size());

        itr = map.entrySet().iterator();

        while (itr.hasNext()) {

            listOFKeys.add(itr.next().getKey());
        }

        itr = map.entrySet().iterator();

        while (itr.hasNext()) {

            listOFValues.add(itr.next().getValue());
        }


        for (int i = 0; i < listOFKeys.size(); i++) {

            if (listOFKeys.get(i).equals(login) && listOFValues.get(i).equals(pass)) {

                return true;
            }
        }

        return false;
    }


    public void add(String login, String pass) {

        if (map.size() != 0) {

            for (String s : map.keySet()) {

                if (s.equals(login)) {

                    System.err.println("Такий логін вже існує");
                    return;

                }


            }
            map.put(login, pass);
        }

        map.put(login, pass);
    }

    public void remove(String login) {

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();


        while (iterator.hasNext()) {

            if (iterator.next().getKey().equals(login)) {

                iterator.remove();
                return;
            }
        }

        System.err.println("Такого користувача не існує");

    }


}

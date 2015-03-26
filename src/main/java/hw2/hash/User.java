package hw2.hash;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 12.05.2014
 * Time: 15:29
 * To change this template use File|Setting|File Templates.
 */

/*Написать модульные тесты для класса пользователь, на методы equals и hashCode.
Поля класса пользователь:
1. Логин
2. Пароль
3. Дата регистрации
4. Рейтинг (вещественное число)
5. Пол


Гейленко Илья*/

public class User {

    private String login;
    private String password;
    private String dateOfRegistration;
    private int rating;
    private String sex;

    public static void main(String[] args) {
        User user1 = new User("Vasa", "123", "male", 12, "1222");
        User user2 = new User("Vasa", "123", "male", 12, "1222");


        System.out.println(user1.equals(user2));
    }

    public User(String login, String password, String sex, int rating, String date) {

        this.login = login;
        this.password = password;
        this.dateOfRegistration = date;
        this.rating = rating;
        this.sex = sex;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        User man = (User) obj;


        return (man.login.equals(this.login) && man.sex.equals(this.sex)
                && man.dateOfRegistration.equals(this.dateOfRegistration))
                && man.sex.equals(this.sex) && man.login.equals(this.login)
                && man.rating == this.rating && man.password.equals(this.password);

    }

    @Override
    public int hashCode() {
        return this.login.hashCode()
                + this.password.hashCode()
                + this.dateOfRegistration.hashCode()
                + this.rating + this.sex.hashCode();
    }

}

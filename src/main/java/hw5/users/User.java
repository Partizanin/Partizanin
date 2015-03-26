package hw5.users;

import java.util.Date;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 05.06.2014
 * Time: 18:08
 * To change this template use File|Setting|File Templates.
 */

/*id, имя, пароль, дата*/
public class User {

    private int id;
    private String name;
    private String password;
    private Date date;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Date getDate() {
        return date;
    }


    public User(int id, String name, String password, Date date) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Name: " + name + "" +
                "\nID: " + id + "" +
                "\nPassword: " + password + "" +
                "\nDate: " + date + "\n\n";
    }
}

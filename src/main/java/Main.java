

/**
 * Created with Intellij IDEA.
 * Project name: ${PROJECT_NAME}
 * User: Partizanin
 * Date: 11.08.2014
 * Time:  11:38
 * To change this template use File|Setting|File Templates.
 */
public class Main {

    public static void main(String[] args) {
        String user = "User_Login";//Логин пользователя
        String password = "User_Password";//Пароль пользователя
        String url = "jdbc:oracle:thin:@localhost:1521/MyDBName";//URL адрес
        String driver = "oracle.jdbc.driver.OracleDriver";//Имя драйвера
        try {
            Class.forName(driver);//Регистрируем драйвер
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

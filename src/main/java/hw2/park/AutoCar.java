package hw2.park;

/**
 * Created with Intellij IDEA.
 * Project name: Курсы
 * User: Partizanin
 * Date: 15.05.2014
 * Time: 18:18
 * To change this template use File|Setting|File Templates.
 */
public class AutoCar {

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrend() {
        return Brend;
    }

    public void setBrend(String brend) {
        Brend = brend;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }


    private String model;
    private String Brend;
    private int Year;


    public AutoCar(String model, String brend, int year) {
        setModel(model);
        setBrend(brend);
        setYear(year);
    }


}

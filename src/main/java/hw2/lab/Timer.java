package hw2.lab;

import java.util.ArrayList;

/**
 * Created with Intellij IDEA.
 * Project name: Курсы
 * User: Partizanin
 * Date: 12.05.2014
 * Time: 15:51
 * To change this template use File|Setting|File Templates.
 */

/*Написать класс, измеряющий время выполнения операций
    - Засеч время в милисекундах по метке(предыдущая, засечка сбрасывается)
	- Сохранить прошедшее время в милисекундах по метке
	- Напечатать прошедшее время в наносекундах по всем меткам

Класс задания hw2.timer.TimerFrame
*/
public class Timer {

    private long time1;
    private long time2;
    private ArrayList<Long> list = new ArrayList<>();


    public void firstLable() {

        time1 = System.currentTimeMillis();

    }

    public void secondLable() {
        time2 = System.currentTimeMillis();
        list.add(time2 - time1);
    }


    public long currentResult() {

        return time2 - time1;
    }

    public void showAllResults() {
        for (Long alist : list) {

            System.out.println(alist);
        }
    }
}

package hw2.park;

/**
 * Created with Intellij IDEA.
 * Project name: Курсы
 * User: Partizanin
 * Date: 14.05.2014
 * Time: 17:21
 * To change this template use File|Setting|File Templates.
 */

/*
 Написать класс представляющий парковку. С методами:
	- int hw2.park(Car cat) - поместить машину на парковку, возвращает номер паркоместа
	- Car leave(int placeNumber) - удалить машину с парковки по номеру парокместа, возвращает удаляемую машину
Методы выбрасывают ислключения IndexOutOfBoundsException и ParkFullException

Класс задания hw2.hw2.park.Parking
*/

public class Parking {

    private Car[] parkingPlaces = new Car[3];
    private int size = 0;

    public int park(Car car) {

        try {
            parkingPlaces[size] = car;
        } catch (IndexOutOfBoundsException e) {
            System.err.println("ParkFullException");
        }

        int ret = size;
        size++;
        return ret;
    }

    public Car leav(int placeNumber) {

        return parkingPlaces[placeNumber];

    }


}

package hw2.lab;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created with Intellij IDEA.
 * Project name: Курсы
 * User: Partizanin
 * Date: 12.05.2014
 * Time: 16:31
 * To change this template use File|Setting|File Templates.
 */

/*Сравнить производительность списков, по следующим методам:
1. Добавление в начало
2. Добавление в конец
3. Добавление в середину
4. Удаление с конца
5. Удаление с начала
6. Получение элемента по индексу
7. Обход списка

Класс задания hw2.lab.ListsCompare
*/
public class ListsCompare {

    private Timer timer = new Timer();
    private ArrayList<Integer> arrayList = new ArrayList<>();
    private LinkedList<Integer> linkedList = new LinkedList<>();


    public long linkedListGetIndex() {

        timer.firstLable();

        for (int i = 0; i < 10000; i++) {
            linkedList.get(linkedList.size() - 200);
        }

        timer.secondLable();


        return timer.currentResult();
    }


    public long arrayListAddToStart() {
        timer.firstLable();

        for (int i = 0; i < 10000; i++) {

            arrayList.add(0, 10000);
        }

        timer.secondLable();

        return timer.currentResult();

    }

    public long linkedListAddToStart() {
        timer.firstLable();

        for (int i = 0; i < 10000; i++) {

            linkedList.add(0, 10000);
        }

        timer.secondLable();

        return timer.currentResult();

    }


    public long arrayListAddToEnd() {
        timer.firstLable();

        for (int i = 0; i < 10000; i++) {

            arrayList.add(arrayList.size() - 1, 10000);
        }

        timer.secondLable();

        return timer.currentResult();
    }


    public long linkedListAddToend() {

        timer.firstLable();

        for (int i = 0; i < 10000; i++) {

            linkedList.add(linkedList.size() - 1, 10000);
        }


        timer.secondLable();

        return timer.currentResult();

    }


    public long arrayListAddToCenter() {
        timer.firstLable();

        for (int i = 0; i < 10000; i++) {

            arrayList.add(arrayList.size() / 2, 10000);
        }

        timer.secondLable();


        return timer.currentResult();

    }


    public long linkedListAddToCenter() {

        timer.firstLable();

        for (int i = 0; i < 10000; i++) {

            linkedList.add(linkedList.size() / 2, 10000);
        }


        timer.secondLable();


        return timer.currentResult();

    }


    public long arrayListRenoveFromStart() {

        timer.firstLable();
        for (int i = 0; i < arrayList.size(); i++) {

            arrayList.remove(arrayList.size() / 2);
        }

        timer.secondLable();


        return timer.currentResult();

    }

    public long linkedListRemoveFromStart() {
        timer.firstLable();

        for (int i = 0; i < linkedList.size(); i++) {

            linkedList.remove(0);
        }

        timer.secondLable();

        return timer.currentResult();
    }


    public long arrayListRemoveFromEnd() {
        timer.firstLable();

        for (int i = 0; i < arrayList.size(); i++) {

            arrayList.remove(arrayList.size() - 1);
        }
        timer.secondLable();

        return timer.currentResult();
    }


    public long linkedListRemoveFromEnd() {

        timer.firstLable();

        for (int i = 0; i < linkedList.size(); i++) {

            linkedList.remove(linkedList.size() - 1);
        }

        timer.secondLable();


        return timer.currentResult();
    }


    public long arrayListGetIndex() {
        timer.firstLable();

        for (int i = 0; i < 10000; i++) {

            arrayList.get(arrayList.size() - 200);
        }

        timer.secondLable();

        return timer.currentResult();
    }


    public long linlkedListGetIndex() {
        timer.firstLable();

        for (int i = 0; i < 10000; i++) {

            linkedList.get(linkedList.size() - 200);
        }

        timer.secondLable();

        return timer.currentResult();
    }


    public long bypassArrayList() {
        timer.firstLable();


        for (Integer anArrayList : arrayList) {

            anArrayList.toString();


        }
        timer.secondLable();


        return timer.currentResult();
    }


    public long bypassLinkedList() {
        timer.firstLable();


        for (Integer aLinkedList : linkedList) {

            aLinkedList.toString();


        }
        timer.secondLable();


        return timer.currentResult();
    }


}

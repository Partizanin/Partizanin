package myWork.other.education;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin.
 * User: Partizanin.
 * Date: 15.11.2014.
 * Time:  18:30.
 * To change this template use File|Setting|Editor|File and Code Templates.
 */
public class MergeTwoArraysAndSorted {

    public static void main(String[] args) {

        Integer[] res = merge(new Integer[]{3, 7, 4, 6, 5}, new Integer[]{10, 1, 9, 2, 8});

        int[] arr = {10, 1, 9, 2, 8, 3, 7, 4, 6, 5};
        bubbleSort2(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static Integer[] merge(Integer[] a, Integer[] b) {
        Integer[] result = new Integer[a.length + b.length];

        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);

        bubbleSort(result);

        return result;
    }

    public static void selectionSort(Integer[] arr) {
    /*По очереди будем просматривать все подмножества
      элементов массива (0 - последний, 1-последний,
      2-последний,...)*/
        for (int i = 0; i < arr.length; i++) {
        /*Предполагаем, что первый элемент (в каждом
           подмножестве элементов) является минимальным */
            int min = arr[i];
            int min_i = i;
        /*В оставшейся части подмножества ищем элемент,
           который меньше предположенного минимума*/
            for (int j = i + 1; j < arr.length; j++) {
                //Если находим, запоминаем его индекс
                if (arr[j] < min) {
                    min = arr[j];
                    min_i = j;
                }
            }
        /*Если нашелся элемент, меньший, чем на текущей позиции,
          меняем их местами*/
            if (i != min_i) {
                int tmp = arr[i];
                arr[i] = arr[min_i];
                arr[min_i] = tmp;
            }
        }
    }

    public static void bubbleSort(Integer[] arr) {
    /*Внешний цикл каждый раз сокращает фрагмент массива,
      так как внутренний цикл каждый раз ставит в конец
      фрагмента максимальный элемент*/
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
            /*Сравниваем элементы попарно,
              если они имеют неправильный порядок,
              то меняем местами*/
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public static void selectionSort2(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            int minV = arr[i];
            int minI = i;

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j] < minV) {
                    minV = arr[j];
                    minI = j;
                }
            }

            if (i != minI) {
                int tmp = arr[i];
                arr[i] = minV;
                arr[minI] = tmp;
            }
        }
    }

    public static void bubbleSort2(int[] arr) {

        for (int i = arr.length - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {

                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

}

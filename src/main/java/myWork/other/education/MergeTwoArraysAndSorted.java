package myWork.other.education;

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
        /*bubbleSort2(arr);*/
        selectionSort2(arr);


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

        for (int i = 0; i < arr.length; i++) {

            int minValue = arr[i];
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j] < minValue) {
                    minIndex = j;
                    minValue = arr[j];
                }
            }

            if (i != minIndex) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;

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

            int minValue = arr[i];
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j] < minValue) {
                    minIndex = j;
                    minValue = arr[j];
                }
            }

            if (i != minIndex) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;

            }
        }
    }

    public static void bubbleSort2(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

}

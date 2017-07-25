package myWork.other.education;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin.
 * User: Partizanin.
 * Date: 01.04.2015.
 * Time:  19:54.
 * To change this template use File|Setting|Editor|File and Code Templates.
 */
public class Sort {

    private static Integer[] numbers;

    public  Integer[] createArray(int length) {
        Integer[] arr = new Integer[length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        Collections.shuffle(Arrays.asList(arr));

        return arr;
    }

    public  void selectionSort(Integer[] array) {

        for (int i = 0; i < array.length; i++) {

            int minValue = array[i];
            int minIndex = i;

            for (int j = i + 1; j < array.length; j++) {

                if (array[j] < minValue) {
                    minIndex = j;
                    minValue = array[j];
                }
            }

            if (i != minIndex) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;

            }
        }
    }

    public  void bubbleSort(Integer[] arr) {
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

    public void gnomeSort(Integer[] theArray) {
        for (int index = 1; index < theArray.length; ) {
            if (theArray[index - 1] <= theArray[index]) {
                ++index;
            } else {
                int tempVal = theArray[index];
                theArray[index] = theArray[index - 1];
                theArray[index - 1] = tempVal;
                --index;
                if (index == 0) {
                    index = 1;
                }
            }
        }
    }

    public  void quickSort(Integer[] values) {
        // check for empty or null array
        if (values == null || values.length == 0) {
            return;
        }
        numbers = values;
        int number = values.length;
        sort(0, number - 1);
    }

    private  void sort(Integer low, Integer high) {
        Integer i = low, j = high;
        // Get the pivot element from the middle of the list
        Integer pivot = numbers[low + (high - low) / 2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller then the pivot
            // element then get the next element from the left list
            while (numbers[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger then the pivot
            // element then get the next element from the right list
            while (numbers[j] > pivot) {
                j--;
            }

            // If we have found a values in the left list which is larger then
            // the pivot element and if we have found a value in the right list
            // which is smaller then the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            sort(low, j);
        if (i < high)
            sort(i, high);
    }

    private  void swap(Integer i, Integer j) {
        Integer temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

}

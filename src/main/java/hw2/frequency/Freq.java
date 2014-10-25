package hw2.frequency;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * Created with Intellij IDEA.
 * Project name: Курсы
 * User: Partizanin
 * Date: 13.05.2014
 * Time: 16:56
 * To change this template use File|Setting|File Templates.
 */

/*
Написать класс для вычисления частоты слов в тексте с методами:
+	- String setTextFromConsole() - вставить текст с консоли
+	- String setTextFromFile(String fileName) - вставить текст с файла
+	- String generateRandomText(int textLength) - сгенерировать текст по количеству слов
+	- Set<String> getWordsByFrequency(int frequency) - вернуть кучу слов  которые встречаються "frequency" раз
+	- Set<String> getWordsByFrequencyLessThan(int frequency) - вернуть кучу слов  которые встречаються менше чем "frequency" раз
+   - Set<String> getWordsByFrequencyMoreThan(int frequency) - вернуть кучу слов  которые встречаються больше чем "frequency" раз
-	- void printAcs() - вывести все слова + частота по возрастанию частоты
-	- void printDesc() - вывести все слова + частота по убыванию частоты

Класс задания hw2.frequency.Freq
*/
public class Freq {


    HashMap<String, Integer> mapOfWords = new HashMap<String, Integer>();


    public void printDesc() {
        Map<String, Integer> tempMap = new HashMap<String, Integer>();
        ValueComparatorDesc bvc = new ValueComparatorDesc(tempMap);
        TreeMap<String, Integer> sorted_map = new TreeMap<String, Integer>(bvc);


        tempMap.putAll(mapOfWords);


        sorted_map.putAll(tempMap);

        System.out.println("results: " + sorted_map);


    }


    void printAcs() {

        Map<String, Integer> tempMap = new HashMap<String, Integer>();
        ValueComparatorAcs bvc = new ValueComparatorAcs(tempMap);
        TreeMap<String, Integer> sorted_map = new TreeMap<String, Integer>(bvc);


        tempMap.putAll(mapOfWords);


        sorted_map.putAll(tempMap);

        System.out.println("results: " + sorted_map);

    }

    public Set<String> getWordsByFrequencyMoreThan(int frequency) {

        Set<String> set = new HashSet<String>();

        for (String key : mapOfWords.keySet()) {

            if (mapOfWords.get(key) > frequency) {

                set.add(key);
            }

        }

        return set;

    }

    public Set<String> getWordsByFrequencyLessThan(int frequency) {
        Set<String> set = new HashSet<>();

        for (String key : mapOfWords.keySet()) {

            if (mapOfWords.get(key) < frequency) {

                set.add(key);
            }

        }
        return set;


    }

    public Set<String> getWordsByFrequency(int frequency) {
        Set<String> set = new HashSet<>();

        for (String key : mapOfWords.keySet()) {

            if (mapOfWords.get(key) == frequency) {

                set.add(key);
            }

        }

        return set;
    }

    public String setTextFromConsole() {
        String text = "";
        Scanner sc = new Scanner(System.in);

        while (true) {

            String s = sc.next();

            if (s.equals("stop")) {
                break;
            } else {

                text += s + " ";
            }

        }

        String[] s = text.split(" ");


        for (String value1 : s) {

            if (!mapOfWords.containsKey(value1)) {

                mapOfWords.put(value1, 1);

            } else {

                int value = mapOfWords.get(value1) + 1;

                mapOfWords.put(value1, value);

            }
        }


        return text;

    }

    public String setTextFromFile(String fileName) {
        String text = "";
        Scanner sc = null;
        try {
            sc = new Scanner(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }

        while (sc.hasNext()) {

            text += sc.next() + " ";
        }

        String[] s = text.split(" ");


        for (String value1 : s) {

            if (!mapOfWords.containsKey(value1)) {

                mapOfWords.put(value1, 1);

            } else {

                int value = mapOfWords.get(value1) + 1;

                mapOfWords.put(value1, value);

            }
        }


        return text;
    }

    public String generateRandomText(int textLength) {
        String text = "";
        ArrayList<String> list = new ArrayList<>();
        list.add("Википедия");
        list.add("универсальная");
        list.add("свободная");
        list.add("общедоступная");
        list.add("Википедия");
        list.add("универсальная");
        list.add("интернет-энциклопедия");
        list.add("реализованная");
        list.add("на");
        list.add("Википедия");
        list.add("произносится");
        list.add("свободная");
        list.add("Википедия");
        list.add("универсальная");
        list.add("универсальная");
        list.add("интернет-энциклопедия");
        list.add("реализованная");
        list.add("на");

        for (String aList : list) {

            if (text.length() < textLength) {
                text += aList + " ";
            } else {
                break;
            }

        }

        for (String aList : list) {

            if (!mapOfWords.containsKey(aList)) {

                mapOfWords.put(aList, 1);

            } else {
                int value = mapOfWords.get(aList) + 1;

                mapOfWords.put(aList, value);
            }
        }


        return text;
    }

    class ValueComparatorAcs implements Comparator<String> {

        Map<String, Integer> base;

        public ValueComparatorAcs(Map<String, Integer> base) {
            this.base = base;
        }


        public int compare(String a, String b) {
            if (base.get(a) >= base.get(b)) {
                return -1;
            } else {
                return 1;
            } // returning 0 would merge keys
        }
    }


    class ValueComparatorDesc implements Comparator<String> {

        Map<String, Integer> base;

        public ValueComparatorDesc(Map<String, Integer> base) {
            this.base = base;
        }


        public int compare(String a, String b) {
            if (base.get(a) >= base.get(b)) {
                return -1;
            } else {
                return 1;
            } // returning 0 would merge keys
        }
    }
}

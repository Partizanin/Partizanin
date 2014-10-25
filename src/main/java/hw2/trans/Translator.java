package hw2.trans;

import java.io.IOException;
import java.io.Reader;
import java.util.*;

/**
 * Created with Intellij IDEA.
 * Project name: Курсы
 * User: Partizanin
 * Date: 13.05.2014
 * Time: 15:10
 * To change this template use File|Setting|File Templates.
 */

/*Написать переводчик с английского языка на русский.
 В качестве аргументов передается ридер файла с оригенальным
  текстом и ридер со словарем (слово = перевод)

Класс задания hw2.trans.Translator
*/
public class Translator {


    public void translate(Reader txt, Reader dictionary) throws IOException {
        Scanner sc;

        Map<String, String> mapDictionary = new HashMap<>();


        ArrayList<String> listText = new ArrayList<>();


        sc = new Scanner(dictionary);

        while (sc.hasNext()) {

            String text = sc.nextLine();
            String[] words = text.split("=");
            String key = words[0];
            String value = words[1];

            mapDictionary.put(key, value);
        }


        sc = new Scanner(txt);

        while (sc.hasNext()) {

            String text = sc.next();

            Iterator<Map.Entry<String, String>> itr = mapDictionary.entrySet().iterator();

            while (itr.hasNext()) {

                String key = itr.next().getKey();

                if (text.equals(key)) {

                    listText.add(mapDictionary.get(key));
                }


            }
            listText.add("-------");

        }
        for (String s : listText) {

            System.out.println(s + " ");
        }
    }


}





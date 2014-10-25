package week6.classwork.arcitecture.View;


import week6.classwork.arcitecture.Domain.Notebook;
import week6.classwork.arcitecture.Service.NotebookServiceImpl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 08.06.2014
 * Time: 18:13
 * To change this template use File|Setting|File Templates.
 */
public class ConsoleControle {


    public void startConsole(NotebookServiceImpl notebookService) {

        Scanner sc = new Scanner(System.in);
        String menu = "1 - Добавить ноутбук \n2 - Показать все\n3 - Вийти";
        int select = 0;


        for (; ; ) {
            System.out.println(menu);
            try {
                select = sc.nextInt();
            } catch (InputMismatchException e) {

                System.err.println("Ви ввели не число!!!");
            }

            if (select == 1) {

                //long serialNumber, String brand, String model, Date creationDate, long price

                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                System.out.println("Введіть серійний номер  ");
                long serilaNumber = 0;
                try {
                    serilaNumber = Integer.parseInt(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Введіть фірму виробника");
                String brand = null;
                try {
                    brand = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Введіть модель ");
                String model = null;
                try {
                    model = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Введіть дату випуска\nНаприклад 12 05 2014");
                String dateCreation = null;
                try {
                    dateCreation = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String[] dateSplit = dateCreation.split(" ");
                Calendar calendar = new GregorianCalendar();
                calendar.set(Calendar.DAY_OF_YEAR, Integer.parseInt(dateSplit[0]));
                calendar.set(Calendar.MONTH, Integer.parseInt(dateSplit[1]));
                calendar.set(Calendar.YEAR, Integer.parseInt(dateSplit[2]));
                System.out.println("Введіть ціну");
                long price = 0;
                try {
                    price = reader.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                notebookService.add(new Notebook(serilaNumber, brand, model, calendar.getTime(), price));

            } else if (select == 2) {

                List<Notebook> list = notebookService.showAll();
                System.err.println(list.size());

                for (Notebook alist : list) {

                    System.out.println(alist);
                }


            } else if (select == 3) {

                System.exit(0);
            } else {
                System.out.println("Ви ввели не вірне значення");
            }

        }

    }
}

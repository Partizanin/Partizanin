package week6.homework.View;

import week6.homework.Service.NotebookServiceImpl;
import week6.homework.domain.Notebook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 10.06.2014
 * Time: 13:29
 * To change this template use File|Setting|File Templates.
 */
public class ConsoleControle {


    public void startConsole(NotebookServiceImpl instance) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String menu = "1 - Добавити ноутбук " +
                "\n2 - Показати всі" +
                "\n3 - Видалити по серійному номеру" +
                "\n4 - Змінити ціну по серійному номеру" +
                "\n5 - Змінити серійний номер і виробника" +
                "\n6 - Шукати по виробнику" +
                "\n7 - Видалити по моделі" +
                "\n8 - Шукати по ціні та даті" +
                "\n9 - Шукати по ціні в указаном діапазоні і даті" +
                "\n10 - Вийти";
        int select = 0;


        for (; ; ) {
            System.out.println(menu);
            try {
                select = Integer.parseInt(reader.readLine());
            } catch (InputMismatchException e) {

                System.err.println("Ви ввели не число!!!");
            }

            if (select == 1) {

                instance.add(addNotebook());

            } else if (select == 2) {

                showAll(instance.showAll());

            } else if (select == 3) {
                System.out.println("Введіть серійний номер");
                long serialNumber = Long.parseLong(reader.readLine());

                instance.deleteBySerialnumber(serialNumber);
                //    instance.deleteBySerialnumber(serialNumber);

            } else if (select == 4) {
                System.out.println("Введіть серійний номер");
                long serialNumber = Long.parseLong(reader.readLine());

                System.out.println("Введіть ціну ");
                long price = Long.parseLong(reader.readLine());

                instance.changePriceBySerialNumber(serialNumber, price);

            } else if (select == 5) {

                System.out.println("Введіть серійний номер який хочете змінити ");
                long serialNumber = Long.parseLong(reader.readLine());
                System.out.println("Введіть серійний номер на який хочете змінити ");
                long changedSerialNumber = Long.parseLong(reader.readLine());
                System.out.println("Введіть виробника ");
                String changedManufactor = reader.readLine();

                instance.changeSerialNumberAndManufactor(serialNumber, changedSerialNumber, changedManufactor);

            } else if (select == 6) {
                System.out.println("Введіть виробника ");
                String manufactor = reader.readLine();

                showAll(instance.findByManufactor(manufactor));

            } else if (select == 7) {
                System.out.println("Введіть модель");
                String model = reader.readLine();

                instance.deleteByModel(model);

            } else if (select == 8) {

                System.out.println("Введіть ціну ");
                long price = Long.parseLong(reader.readLine());

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

                System.out.println(instance.findByPriceAndDate(price, calendar.getTime()));

            } else if (select == 9) {


                System.out.println("Введіть діапазон ціни ");
                System.out.print("Від ");
                long price1 = Long.parseLong(reader.readLine());
                System.out.print("До");
                long price2 = Long.parseLong(reader.readLine());


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

                System.out.println("Введіть виробника ");
                String manufactor = reader.readLine();


                List<Notebook> list = instance.findByPriceRangeYearAndManufactor(price1, price2, calendar.getTime(), manufactor);
                showAll(list);

            } else if (select == 10) {
                System.exit(0);
            } else {
                System.err.println("Ви ввели не вірне значення");
            }

        }

    }


    public static Notebook addNotebook() {

        //long serialNumber, String brand, String model, Date creationDate, long price

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введіть серійний номер  ");
        long serilaNumber = 0;
        try {
            serilaNumber = Long.parseLong(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Введіть фірму виробника");
        String manufactor = null;
        try {
            manufactor = reader.readLine();
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
        long price = 0;
        System.out.println("Введіть продавця ");
        String vendor = "";
        try {
            vendor = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Введіть ціну");
        try {
            price = Long.parseLong(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //long serial, String vendor, String model, String manufactor, Date date, int price

        return new Notebook(serilaNumber, vendor, model, manufactor, calendar.getTime(), price);
    }

    public static void showAll(List<Notebook> list) {
        System.err.println("list.size = " + list.size());

        for (Notebook alist : list) {

            System.out.println(alist);
        }

    }


}

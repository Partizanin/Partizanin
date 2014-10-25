package hw3.graf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created with Intellij IDEA.
 * Project name: Курсы
 * User: Partizanin
 * Date: 20.05.2014
 * Time: 12:08
 * To change this template use File|Setting|File Templates.
 */

/*Пользователь выбирает график функции (x*x, sin(x), x).
Построить график выбранной функции звездочками в консоле, на промежутке 0-5.
Плавно строить график заданной функции пока пользователь не нажмет ентер.

Класс задания:
hw3.graf.GrafPresente
*/
public class GrafPresente {
    public static void main(String[] args) {
        GrafPresente graph = new GrafPresente();
        graph.starting();
    }

    private void stopProg() {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextLine()) {
            System.exit(0);
        }
    }

    private void starting() {
        String s = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Виберіть графік:\n1 - Линейный" +
                "\n2 - Парабола" +
                "\n3 - Синусоидный" +
                "\n- Для выхода нажмите 'enter'");

        try {
            s = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }


        if (s.equals("1")) {
            startGraphX();


        } else if (s.equals("2")) {
            startGraphX2();

        } else if (s.equals("3")) {
            startGraphSinX();

        } else if (s.equals("")) {
            System.exit(0);
        }

    }

    public void startGraphX() {
        GraphX graphX = new GraphX();
        graphX.start();
        stopProg();


    }

    public void startGraphX2() {
        GraphX2 graphX2 = new GraphX2();
        graphX2.start();
        stopProg();
    }

    public void startGraphSinX() {
        GraphSinX graphSinX = new GraphSinX();
        graphSinX.start();
        stopProg();
    }

    public static class GraphSinX extends Thread {

        public void run() {

            double y = 0;

            for (double i = 0; i < 10000; i++) {

                y = (Math.sin(i / 3) * 10) + 20;

                for (int i1 = 0; i1 < y; i1++) {

                    System.out.print(" ");
                }
                System.out.print("*");
                System.out.println();

                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static class GraphX extends Thread {

        public void Graphx() {

        }

        public void run() {
            for (int i = 0; i < 20; i++) {

                for (int j = 0; j < i; j++) {
                    System.out.print(" ");
                }


                System.out.println("*");
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }


    public static class GraphX2 extends Thread {

        public void run() {
            int y;
            for (int x = 0; x < 13; x++) {
                y = x * x + 10;
                for (int i = 0; i < y; i++) {
                    System.out.print(" ");
                }
                System.out.print("*");
                System.out.println();
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}


        



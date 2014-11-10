package myWork.javaChat;

import java.net.*;
import java.io.*;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 01.11.2014
 * Time:  12:36
 * To change this template use File|Setting|File Templates.
 */

public class Server {
    public static void main(String[] ar) {
        int port = 6666; // случайный порт (может быть любое число от 1025 до 65535)
        try {
            /*46.185.15.47*/
            System.out.println("Starting server...");
            ServerSocket ss = new ServerSocket(port, 0, InetAddress.getLocalHost()); // создаем сокет сервера и привязываем его к вышеуказанному порту
            System.out.println("Server has started");
            System.out.println("Server ip: " + ss.getInetAddress());
            System.out.println("Server port: " + ss.getLocalPort());
            System.out.println("Server channel: " + ss.getChannel());
            System.out.println("Server localAdress: " + ss.getLocalSocketAddress());
            InetAddress addr = ss.getInetAddress();
            System.out.println("Server internetAndres: " + addr.getHostName());
            System.out.println("Server internetAndres: " + addr.getCanonicalHostName());
            System.out.println("Server internetAndres: " + addr.getHostAddress());
            System.out.println("");
            System.out.println("Waiting for a client...");
            Socket socket = ss.accept(); // заставляем сервер ждать подключений и выводим сообщение когда кто-то связался с сервером
            System.out.println("Got a client :) ... Finally, someone saw me through all the cover!");
            System.out.println();
            System.out.println("Client ip: " + socket.getInetAddress());

            // Берем входной и выходной потоки сокета, теперь можем получать и отсылать данные клиенту.
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            // Конвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщения.
            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            String line = null;
            while (true) {
                line = in.readUTF(); // ожидаем пока клиент пришлет строку текста.
                System.out.println("The dumb client just sent me this line : " + line);
                System.out.println("I'm sending it back...");
                out.writeUTF(line); // отсылаем клиенту обратно ту самую строку текста.
                out.flush(); // заставляем поток закончить передачу данных.
                System.out.println("Waiting for the next line...");
                System.out.println();
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}

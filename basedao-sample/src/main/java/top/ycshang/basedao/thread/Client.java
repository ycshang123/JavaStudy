package top.ycshang.basedao.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-28 00:29
 **/
public class Client {
    private Socket socket;

    public Client() {
        try {
            this.socket = new Socket("localhost", 8080);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Client(String host, int port) {
        try {
            this.socket = new Socket(host, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(String info) {
        try {
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            writer.print(info);
            writer.flush();
            System.out.println("Client:     send message: " + info);
            socket.shutdownOutput();

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String temp;
            StringBuilder message = new StringBuilder();
            while ((temp = reader.readLine()) != null) {
                message.append(temp);
                System.out.println("Client:     Get message from server: " + message);
            }
            writer.close();
            reader.close();
            socket.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
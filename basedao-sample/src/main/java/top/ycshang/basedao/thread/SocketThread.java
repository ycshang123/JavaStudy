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
 * @create: 2021-11-28 00:30
 **/
public class SocketThread implements Runnable {
    private Socket socket;

    public SocketThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            String temp;
            StringBuilder info = new StringBuilder();
            while ((temp = reader.readLine()) != null) {
                info.append(temp);
                System.out.println("Server:     Get Message");
                System.out.println("Server:     Message:" + info + "， ip address:" + socket.getInetAddress().getHostAddress());
            }
            writer.print("receive the message");
            writer.flush();
            socket.shutdownOutput();
            writer.close();
            reader.close();
            socket.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
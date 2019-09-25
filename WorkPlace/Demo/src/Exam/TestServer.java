package Exam;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(6000);
            while (true){
                socket = server.accept();
                InputStream is = socket.getInputStream();
                new Thread(new WriterOutput(socket)).start();
                new Thread(new MyThread(socket)).start();
            }
        } catch (IOException e) {
            try {
                server.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
class MyThread extends Thread{
    Socket socket;

    public MyThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader reader = null;
        String line;
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true){
                if ((line=reader.readLine())!=null && !"over".equals(line))
                    System.out.println(line);

                else{
                    break;
                }
            }
            closeThread();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader!=null)
                    reader.close();
                if (socket!=null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void closeThread(){
        if (this.interrupted())this.interrupt();
    }
}

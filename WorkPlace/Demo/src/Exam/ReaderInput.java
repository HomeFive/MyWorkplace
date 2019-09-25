package Exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReaderInput implements Runnable{
    Socket socket;

    public ReaderInput(Socket socket) {
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
                    reader.close();
                    break;
                }
            }
            Thread.currentThread().interrupt();
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
}

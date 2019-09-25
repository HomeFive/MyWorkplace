package Exam;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class WriterOutput implements Runnable {
    Socket socket;
    public WriterOutput(Socket socket) { this.socket = socket; }
    @Override
    public void run() {
        BufferedWriter writer = null;
        Scanner s = new Scanner(System.in);
        try {
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String line = null;
            while (true){
                line = s.nextLine();
                writer.write(line);
                writer.newLine();
                writer.flush();
                if (line.equals("over"))
                    if (Thread.currentThread().interrupted())
                        Thread.currentThread().interrupt();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer!=null)
                    writer.close();
                if (socket!=null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

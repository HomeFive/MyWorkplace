package Exam;

import java.io.*;
import java.net.Socket;

public class TestClient {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1",6000);
            new Thread(new WriterOutput(socket)).start();
            new Thread(new ReaderInput(socket)).start();
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
    }
}

package lesson0905.Day2004;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MySocket {
    public static void main(String[] args) {
        try {
            String me = "127.0.0.1";
            Socket sk = new Socket(me,8888);
            OutputStream os = sk.getOutputStream();
            Scanner s = new Scanner(System.in);
            while(true){
                os.write(s.nextLine().getBytes());
                os.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

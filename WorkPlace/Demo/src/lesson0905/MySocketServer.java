package lesson0905;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MySocketServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(5555);
            Socket socket= null;
            while (true){
                socket = ss.accept();
                InputStream is = socket.getInputStream();
                byte[] bytes = new byte[1024];
                int len;
                while((len= is.read(bytes))!=-1){
                    System.out.println(new String(bytes,0,len));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class SocketHandler{
        Socket s;
        InputStream is;
    }
}

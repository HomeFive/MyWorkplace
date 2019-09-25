package lesson0905.Day2003;

import java.io.IOException;
import java.net.*;

public class UDPClient {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket();
            String str = "hello world";
            DatagramPacket dp = new DatagramPacket(str.getBytes(),str.length(),
                    InetAddress.getByName("localhost"),2000);
            ds.send(dp);
            ds.close();
            System.out.println("发送完成");
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

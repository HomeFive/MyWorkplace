package lesson0905.Day2003;

import java.io.IOException;
import java.net.*;

public class UDPServer {
    public static void main(String[] args) {
        DatagramSocket ds = null;
        DatagramPacket dp = null;
        try {
            ds = new DatagramSocket(2000);
            byte[] data = new byte[1024];
            dp = new DatagramPacket(data,data.length);
            ds.receive(dp);
            System.out.println(new String(dp.getData(),0,dp.getLength()));
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            ds.close();
        }
    }
}

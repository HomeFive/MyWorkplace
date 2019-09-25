package lesson0905.Day2008;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class LoginClient {
    public static void main(String[] args) {
        Socket client = null;
        OutputStream os = null;
        InputStream is = null;
        try {
            client = new Socket("localhost",5000);
            is = client.getInputStream();
            os = client.getOutputStream();
            System.out.println("客户端就绪");
            System.out.println("请输入账户和密码，格式如”user=password“：");
            os.write(new Scanner(System.in).next().getBytes());
            byte[] bytes = new byte[1024];
            int len = 0;
            if((len=is.read(bytes))!=-1) {
                System.out.println(new String(bytes,0,len));
            }
        } catch (IOException e) {
            try {
                client.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                client.shutdownOutput();
                client.shutdownInput();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

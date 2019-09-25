package lesson0905.Day2006;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MySocket {
    public static void main(String[] args) {
        String me = "127.0.0.1";
        String he = "192.168.31.137";
        String user = "CXH Say";
        Socket client = null;
        OutputStream os = null;
        InputStream is = null;
        BufferedWriter bw = null;
        BufferedReader br = null;
        Scanner s = new Scanner(System.in);
        String send = null;
        try {
            client = new Socket(he,8888);
            bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            is = client.getInputStream();
            String line = null;
            System.out.println("客户端就绪");
            boolean flag = false;
            while(!flag){
                bw.flush();
                send = s.nextLine();
                bw.write(user+"："+send+"\r\n");
                bw.flush();
                if ("exit".equals(send)){
                    System.out.println("System Call: EXIT");
                    br = new BufferedReader(new InputStreamReader(is));
                    line = br.readLine();
                    System.out.println("line . getlength:"+line.length());
                    if ("agree".equals(line.substring(0,5))){
                        System.out.println("System Agree");
                        flag = true;
                    }
                }else{
                    System.out.println("已发送");
                    br = new BufferedReader(new InputStreamReader(is));
                    line = br.readLine();
                    System.out.println("来自服务器的信息："+line);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            try {
                bw.close();
                br.close();
                client.close();
                System.out.println("发生异常，断开连接");
            } catch (IOException e1) {
                System.out.println("二重异常");
                e1.printStackTrace();
            }
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
        } finally {
            try {
                bw.close();
                br.close();
                client.close();
                System.out.println("服务器已断开连接");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}

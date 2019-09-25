package lesson0905.Day2006;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MySocketServer {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket= null;
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            server= new ServerSocket(5555);
            boolean flag = false;
            while (!flag){
                socket = server.accept();
                System.out.println("服务器就绪");
                String line = null;
                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while(true){
                    line= br.readLine();
                    System.out.println("来自客户端的消息："+line);
                    bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    bw.flush();
                    System.out.println("line.getlength:"+line.length());
                    if ("exit".equals(line.substring(8,line.length()))){
                        System.out.println("get exit");
                        bw.write("agree");
                        bw.flush();
                        flag = true;
                        break;
                    }else {
                        bw.write("服务器："+new Scanner(System.in).nextLine() +"\r\n");
                        bw.flush();
                        System.out.println("已发送");
                    }
                }
            }
        } catch (IOException e) {
            try {
                bw.close();
                br.close();
                server.close();
                System.out.println("发生异常，断开连接");
            } catch (IOException e1) {
                System.out.println("二重异常");
                e1.printStackTrace();
            }
        } catch (NullPointerException e){
            e.printStackTrace();
        } finally {
            try {
                bw.close();
                br.close();
                server.close();
                System.out.println("服务器已关闭");
            } catch (IOException e1) {
                System.out.println("finally");
                e1.printStackTrace();
            }
        }
    }
}

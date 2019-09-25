package lesson0905.Day2008;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

public class LoginServer {
    public static void main(String[] args) {
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(5000);
            while (true){
                Socket server = ss.accept();
                new Thread(()->{
                    InputStream is = null;
                    OutputStream os = null;
                    int len;
                    String line;
                    try {
                        is = server.getInputStream();
                        os = server.getOutputStream();
                        System.out.println("服务器就绪");
                        for (byte[] bytes = new byte[8*1024]; (len=is.read(bytes))!=-1 ; ) {
                            line = new String(bytes,0,len);
                            System.out.println("收到的账户密码："+line);
                            String []msg = line.split("=");
                            if (msg.length==1)
                                os.write("输入格式错误".getBytes());
                            else {
                                Properties p = new Properties();
                                p.load(new FileInputStream("d:/1/log.txt"));
                                if (p.containsKey(msg[0])){
                                    if (p.getProperty(msg[0]).equals(msg[1])){
                                        os.write("登录成功".getBytes());
                                    }else {
                                        os.write("密码不正确".getBytes());
                                    }
                                } else{
                                    p.setProperty(msg[0],msg[1]);
                                    try {
                                        p.store(new FileOutputStream("d:/1/log.txt"),"new account regestered in"+System.currentTimeMillis());
                                        os.write("注册成功".getBytes());
                                    }catch (Exception e){
                                        os.write("注册失败".getBytes());
                                    }
                                }
                            }
                        }
                    } catch (IOException e) {
                        if (!Thread.currentThread().isInterrupted())
                            Thread.currentThread().interrupt();
                    } finally {
                        try {
                            server.shutdownOutput();
                            server.shutdownInput();
                        } catch (IOException e) {
                            try {
                                System.out.println("on server close:"+e.getMessage());
                                server.close();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        }

                    }
                }).start();
            }
        } catch (IOException e) {
            System.out.println("unknown exception:"+e.getMessage());
        }
    }
}

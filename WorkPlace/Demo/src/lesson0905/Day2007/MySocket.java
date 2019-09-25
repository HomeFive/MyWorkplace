package lesson0905.Day2007;

import java.io.*;
import java.net.Socket;
import java.util.Collection;
import java.util.Scanner;

public class MySocket {
    public static void main(String[] args) {
        MySocket ms = new MySocket();
        Socket sk = null;
        try {
            String me = "127.0.0.1";
            String localhost = "192.168.31.164";
            sk = new Socket(me,5555);
            System.out.println("客户端就绪");
            new Thread(ms.new UploadHandler(sk)).start();
            new Thread(ms.new InputStreamHandler(sk)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private class InputStreamHandler implements  Runnable {
        Socket socket;

        public InputStreamHandler(Socket socket) { this.socket = socket; }

        @Override
        public void run() {
            InputStream is = null;
            Scanner s = new Scanner(System.in);
            try {
                is = socket.getInputStream();
                byte[] bytes= new byte[8*1024];
                int len = 0;
                int i = 0;
                while (true) {
                    i = is.available();
                    len=is.read(bytes);
                    if ( (i!=0||i!=1) && len!=-1)
                        System.out.println("来自服务器的消息："+new String(bytes,0,len));
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println(e.getStackTrace());
                System.out.println(e.getCause());
                System.out.println(e.getMessage());
            } finally {
                try {
                    if (is!=null)
                        is.close();
                } catch (IOException e) {
                        System.out.println(e.getStackTrace());
                        System.out.println("inputrsteam can not close: error from finally");
                }
            }
        }
    }
    private class UploadHandler implements  Runnable {
        Socket socket;

        public UploadHandler(Socket socket) { this.socket = socket; }

        @Override
        public void run() {
            DataOutputStream dos = null;
            String fileName = null;
            try {
                dos = new DataOutputStream(socket.getOutputStream());
                System.out.println("请输入文件的路径：");
                fileName = new Scanner(System.in).next();
                File file = new File(fileName);
                while(!file.exists()) {
                    System.out.println("找不到该文件，请输入存在的文件的路径：");
                    fileName = new Scanner(System.in).next();
                    file = new File(fileName);
                }
                FileInputStream fis = new FileInputStream(file);
                dos.writeUTF(file.getName());
                dos.flush();
                dos.writeLong(file.length());
                dos.flush();
                byte[] bytes = new byte[1024*8];
                long progress = 0;
                for (int len=0,i=0;(len=fis.read(bytes))!=-1;i++){
                    dos.write(bytes,0,len);
                    progress+=len;
                    if (i%2==0)
                        System.out.println("| 文件上传进度："+100*progress/file.length()+"% |");
                }
                System.out.println("上传结束");
            } catch (IOException e) {
                System.out.println(e.getStackTrace());
                System.out.println(e.getCause());
                System.out.println(e.getMessage());
            } finally {
                try {
                    if (dos!=null)
                        dos.close();
                    /*socket.shutdownOutput();
                    socket.close();*/
                } catch (IOException e) {
                    System.out.println(e.getStackTrace());
                    System.out.println("outputstream can not close");
                }
            }
        }
    }
}

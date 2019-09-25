package lesson0905.Day2007;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MySocketServer {
    public static void main(String[] args) {
        MySocketServer mss = new MySocketServer();
        try {
            ServerSocket ss = new ServerSocket(5555);
            Socket socket= null;
            while (true){
                socket = ss.accept();
                new Thread(mss.new DownloadHandler(socket)).start();
                new Thread(mss.new OutputStreamHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class DownloadHandler implements Runnable {
        Socket socket;
        public DownloadHandler(Socket socket) {
            this.socket = socket;
            System.out.println("开始下载文件...");
        }

        @Override
        public void run(){
            DataInputStream dis = null;
            int len;
            try {
                dis = new DataInputStream(socket.getInputStream());
                String fileName = dis.readUTF();
                long fileLength = dis.readLong();
                byte[] bytes = new byte[1024*8];
                System.out.println(fileName+"|"+fileLength);
                File file = new File("D:/2/Download");
                file.mkdirs();
                FileOutputStream fos = new FileOutputStream(new File(file,fileName));
                while((len= dis.read(bytes))!=-1){
                    fos.write(bytes,0,len);
                    fos.flush();
                }
                System.out.println("| 文件下载完成，文件大小："+getSizeString(fileLength)+" |");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (dis!=null) {
                        dis.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private class OutputStreamHandler implements  Runnable {
        Socket socket;

        public OutputStreamHandler(Socket socket) { this.socket = socket; }

        @Override
        public void run() {
            OutputStream os = null;
            try {
                os = socket.getOutputStream();
                byte[] bytes = new byte[1024*8];
                while(true){
                    os.write(bytes,0,new Scanner(System.in).nextLine().getBytes().length);
                    os.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static String getSizeString(long size){
        if(size<1024)
            return size+"B";
        if(size<1024*1024)
            return size/1024+"KB";
        if(size<1024*1024*1024)
            return size/1024/1024+"MB";
        return "";
    }
}

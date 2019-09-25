package lesson0905.Day2009;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class DownloadServer {
    public static void main(String[] args) {
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(5001);
            while (true){
                Socket server = ss.accept();
                new Thread(()->{
                    InputStream is;
                    OutputStream os;
                    FileInputStream fis = null;
                    try {
                        is = server.getInputStream();
                        os = server.getOutputStream();
                        byte[] bytes = new byte[1024*8];
                        int len;
                        if((len=is.read(bytes))!=-1){
                            String path = new String(bytes,0,len);
                            System.out.println("请求的文件："+path);
                            File file = new File(path);
                            if (file.exists()){
                                for (fis = new FileInputStream(file);(len=fis.read(bytes))!=-1;){
                                    os.write(bytes,0,len);
                                }
                                System.out.println("文件发送完毕");
                            }
                        }
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    } finally {
                        try {
                            if (fis!=null)
                                fis.close();
                            server.shutdownInput();
                            server.shutdownOutput();
                            server.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package lesson0905.Day2009;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class DownloadClient {
    public static void main(String[] args) {
        Socket client = null;
        OutputStream os = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            client = new Socket("localhost",5001);
            os = client.getOutputStream();
            is = client.getInputStream();
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入要下载的文件完整路径：");
            String fileName = scanner.next();
            os.write(fileName.getBytes());
            System.out.println("已发送请求");
            byte[] bytes = new byte[1024*8];
            System.out.println("指定下载文件的存放路径：");
            File target = new File(scanner.next());
            if (!target.exists())
                target.mkdirs();
            fos = new FileOutputStream(new File(target,new File(fileName).getName()));
            for (int len;(len=is.read(bytes))!=-1;){
                fos.write(bytes,0,len);
            }
            System.out.println("文件下载完成");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos!=null)
                    fos.close();
                client.shutdownOutput();
                client.shutdownInput();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

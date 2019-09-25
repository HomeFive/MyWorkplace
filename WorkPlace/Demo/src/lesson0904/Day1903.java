package lesson0904;

import java.io.*;

public class Day1903 {
    public static void main(String[] args) {
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream("d:/1/8.bmp"));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("d:/1/7.bmp",true));
            int len;
            byte[] bytes = new byte[1024*8];
            while ((len=bis.read(bytes))!=-1)
                bos.write(bytes,0,len);
            bos.close();
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

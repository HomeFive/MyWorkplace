package lesson0903;

import java.io.*;

public class Day1807 {
    public static void main(String[] args) {
        File img = new File("d:/1/7.bmp");
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(img);
            byte[] bytes = new byte[1024];
            fos = new FileOutputStream("d:/abc空文件夹/"+img.getName());
            for (int len=0;(len=fis.read(bytes))!=-1;){
                fos.write(bytes);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

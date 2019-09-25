package Exam;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileCopy {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File f = new File("D:\\a.txt");
            fis = new FileInputStream(f);
            new File("D:\\test2").mkdir();
            fos = new FileOutputStream(new File("D:\\test2",new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())+f.getName()));
            byte[] bytes = new byte[1024*8];
            for (int len;(len=fis.read(bytes))!=-1;fos.write(bytes)){}
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos!=null)
                    fos.close();
                if (fis!=null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

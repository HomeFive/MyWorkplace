package lesson0903;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class Day1812 {
    public static void main(String[] args) {
        /*创建score.txt
        try {
            FileOutputStream fos = null;
            fos = new FileOutputStream("d:/1/score.txt");
            fos.write("zhangsan = 90\r\nlisi = 80\r\nwangwu = 85".getBytes());
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        */
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("d:/1/score.txt");
            Properties ps = new Properties();
            ps.load(fis);
            for (Object key:ps.keySet()){
                if (key.equals("lisi"))
                    ps.put(key,100);
            }
            fos = new FileOutputStream("d:/1/score.txt");
            for (Map.Entry en:ps.entrySet()) {
                fos.write((en.getKey()+" = "+en.getValue()+"\r\n").getBytes());
            }
            fos.flush();
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

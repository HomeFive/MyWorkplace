package lesson0903;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Day1805 {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("d:/1/a.b.c.d");
            byte[] bytes = new byte[1024];
            int len;
            while ((len=fis.read(bytes))!=-1)
                System.out.print(new String(bytes,0,len));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

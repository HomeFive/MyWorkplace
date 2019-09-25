package lesson0903;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Day1804 {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("d:/1/a.b.c.d");
            int len;
            while ((len = fis.read()) != -1)
                System.out.print((char)len);
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

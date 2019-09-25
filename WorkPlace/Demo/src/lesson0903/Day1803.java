package lesson0903;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Day1803 {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("d:/1/a.b.c.d",true);
            for (int i = 0; i <5 ; i++) {
                fos.write("\r\ni love java".getBytes());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

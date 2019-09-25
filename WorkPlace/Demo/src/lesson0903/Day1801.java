package lesson0903;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Day1801 {
    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("c:/a.txt");
            fos.write("hello world".getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

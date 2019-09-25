package lesson0903;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Day1802 {
    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("d:/1/a.b.c.d",true);
            fos.write("good bye,sir".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

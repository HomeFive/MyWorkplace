package lesson0904;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Day1902 {
    public static void main(String[] args) {
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("d:/1/Info.txt",true));
            bos.write("good game".getBytes());
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

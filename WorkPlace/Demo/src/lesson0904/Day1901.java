package lesson0904;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Day1901 {
    public static void main(String[] args) {
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("d:/1/Info.txt",true));
            bos.write('a');
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

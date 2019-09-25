package lesson0904;

import org.junit.Test;

import java.io.*;

public class Day1905 {
    @Test
    public void testGBK(){
        String str = "我爱java";
        FileOutputStream fos = null;
        OutputStreamWriter osr = null;
        try {
            fos = new FileOutputStream("d:/1/a.txt");
            osr = new OutputStreamWriter(fos,"GBK");
            osr.write(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                osr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

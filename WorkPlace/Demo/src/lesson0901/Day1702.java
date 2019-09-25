package lesson0901;

import java.io.File;
import java.io.IOException;

public class Day1702 {
    public static void main(String[] args) {
        File f = new File("c:\\a.txt");
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

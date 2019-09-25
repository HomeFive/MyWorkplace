package lesson0901;

import java.io.File;

public class Day1708 {
    public static void main(String[] args) {
        File f = new File("c:/a.aaa");
        for (File file: f.listFiles()){
            System.out.println(file.getName());
        }
    }
}

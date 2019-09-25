package lesson0901;

import java.io.File;

public class Day1701 {
    public static void main(String[] args) {
        String relativePath = "abc.txt";
        String absolutePath = "D:\\win\\123";
        File f = new File(absolutePath);
        File f2 = new File(absolutePath,relativePath);
    }
}

package lesson0901;

import java.io.File;

public class Day1707 {
    public static void main(String[] args) {
        File f1 = new File("c:/a.txt");
        File f2 = new File("c:/a.aaa");
        System.out.println(f1.getName()+"是文件夹吗？"+f1.isDirectory()+"\n，是文件吗？"+f1.isFile());
        System.out.println(f2.getName()+"是文件夹吗？"+f2.isDirectory()+"\n，是文件吗？"+f2.isFile());
    }
}

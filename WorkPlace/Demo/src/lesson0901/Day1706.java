package lesson0901;

import java.io.File;

public class Day1706 {
    public static void main(String[] args) {
        File f = new File("c:/aaa/b.txt");
        System.out.println("文件名："+f.getName()+"，文件大小："+f.length()+"，文件绝对路径："+f.getAbsolutePath()+"，父路径："+f.getParent());
    }
}

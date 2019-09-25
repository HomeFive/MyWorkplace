package lesson0901;

import java.io.File;
import java.util.Scanner;

public class Day1712 {
    public static void main(String[] args) {
        System.out.println("请输入文件夹的路径：");
        File f = new File(new Scanner(System.in).next());
        if (f.isFile())
            System.out.println(f.getName()+"的大小是"+f.length());
        else {
            int size = 0;
            for (File file : f.listFiles())
                if (file.isFile())
                    size+=file.length();
            System.out.println(f.getName()+"的大小是"+size);
        }
    }
}

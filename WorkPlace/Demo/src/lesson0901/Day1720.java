package lesson0901;

import java.io.File;
import java.util.Scanner;

public class Day1720 {
    public static void main(String[] args) {
        File f = new File(new Scanner(System.in).next());
        show(f);
    }
    public static void show(File file){
        if (!file.exists()){
            System.out.println("不存在的文件或文件夹："+file.getName());
            return;
        }
        System.out.println(file.getName());
        if (file.isDirectory()){
            File[] files = file.listFiles();
            if (files!=null)
                for (File f : files)
                    show(f);
        }
    }
}

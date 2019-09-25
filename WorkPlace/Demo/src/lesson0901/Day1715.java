package lesson0901;

import java.io.File;
import java.util.Scanner;

public class Day1715 {
    public static void main(String[] args) {
        System.out.println("请输入文件夹的路径：");
        File f = new File(new Scanner(System.in).next());
        deleteStraightly(f);
    }
    public static void deleteStraightly(File file){
        if (!file.exists()){
            System.out.println("文件夹不存在");
            return;
        }
        if (file.isDirectory())
            for (File f : file.listFiles())
                deleteStraightly(f);
        file.delete();
    }

}

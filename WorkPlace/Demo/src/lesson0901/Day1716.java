package lesson0901;

import java.io.File;
import java.util.Scanner;

public class Day1716 {
    public static void main(String[] args) {
        System.out.println("请输入文件夹的路径：");
        File f = new File(new Scanner(System.in).next());
        System.out.println(f.getAbsolutePath()+"的大小是"+calculate(f)+"字节");
    }
    public static long calculate(File file){
        long size=0;
        if (!file.exists()){
            System.out.println("文件夹不存在");
            return 0;
        }else {
            if (file.isDirectory()){
                for (File f : file.listFiles()){
                    size+=calculate(f);
                }
            }else {
                size+=file.length();
            }
        }
        return size;
    }

}

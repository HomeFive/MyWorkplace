package lesson0901;

import java.io.File;
import java.util.Scanner;

public class Day1713 {
    public static void main(String[] args) {
        System.out.println("请输入文件夹的路径：");
        File f = new File(new Scanner(System.in).next());
        showAll(f);
    }
    public static void showAll(File file){
        if (!file.exists()){
            System.out.println("文件夹不存在");
        }else {
            if (file.isDirectory() && file.list()!=null){
                for (File f : file.listFiles()){
                    showAll(f);
                }
            }else {
                System.out.println(file.getAbsolutePath());
            }
        }
    }

}

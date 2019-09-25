package lesson0901;

import java.io.File;
import java.util.Scanner;

public class Day1711 {
    public static void main(String[] args) {
        System.out.println("请输入文件路径：");
        File f = new File(new Scanner(System.in).next());
        if (f.exists())
            System.out.println(f.length());
        else{
            File fp = new File(f.getParent());
            if (!fp.exists()){
                System.out.println("create parent");
                fp.mkdirs();
            }
            try {
                if (fp.exists()){
                    System.out.println("父路径："+fp.getAbsolutePath());
                }
                //没有在C：/下创建文件的权限时出现IOException
                new File(fp,f.getName()).createNewFile();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

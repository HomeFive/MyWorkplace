package lesson0901;

import java.io.File;
import java.util.Scanner;

public class Day1717 {
    public static void main(String[] args) {
        File f = new File(new Scanner(System.in).next());
        find200K(f);
    }
    public static void find200K(File file){
        try {
            for (File f1:file.listFiles())
                if (f1.isDirectory()){
                    System.out.println(f1.getAbsolutePath());
                    find200K(f1);
                }
        }catch (Exception e){}
        for (File f2:file.listFiles((f) -> {
            if (f.length()<=200*1024) return true;
            return false;
        }))
            System.out.println(f2.getName());
    }
}

package lesson0901;

import java.io.File;
import java.io.FileFilter;
import java.util.Scanner;

public class Day1714 {
    public static void main(String[] args) {
        System.out.println("请输入文件夹的路径：");
        File f = new File(new Scanner(System.in).next());
        FileFilterImpl fileFilter = new Day1714().new FileFilterImpl();
        for (File file: f.listFiles(fileFilter))
            System.out.println(file.getName());
    }
    class FileFilterImpl implements FileFilter{

        @Override
        public boolean accept(File pathname) {
            if (pathname.getName().endsWith(".java"))
                return true;
            return false;
        }
    }
}

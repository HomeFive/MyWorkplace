package lesson0903;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Day1813 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        File java = new File("C:/java");
        java.mkdir();
        findAndCountJava(new File(s.next()));
        System.out.println("java文件个数是"+new File("C:/java").list().length);
    }
    static void findAndCountJava(File file){
        if (!file.exists()){
            System.out.println("该文件不存在");
            return;
        }
        if (file.isFile()){
            if (file.getName().endsWith(".java"))
                copyJava(file);
        }else{
            System.out.println(file.getAbsolutePath());

            File[] files = file.listFiles(pathname -> {
                if (pathname.getName().endsWith(".java"))
                    return true;
                return false;
            });
            if (files!=null)
                for (File java : files)
                    copyJava(java);
            if (file.list()!=null)
                for (File f: file.listFiles())
                    if (f.isDirectory())
                        findAndCountJava(f);
        }
    }
    static void copyJava(File file){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(file);
            byte[] bytes = new byte[1024 * 8];
            int len;
            Date d = new Date();
            String name = file.getName();
            fos = new FileOutputStream("C:/java/"+name.substring(0,name.length()-5)+new SimpleDateFormat("yyyyMMddHHmmssSSS").format(d.getTime())+".java");
            while ((len=fis.read(bytes))!=-1){
                fos.write(bytes,0,len);
                fos.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

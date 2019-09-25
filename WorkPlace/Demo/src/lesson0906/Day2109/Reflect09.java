package lesson0906.Day2109;

import java.io.*;
import java.util.Properties;

public class Reflect09 {
    public static void main(String[] args) {
        File read = new File("D:\\MyWorkplace\\WorkPlace\\Demo\\src\\lesson0906\\Day2109\\read.txt");
        Properties p = new Properties();
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            if (!read.exists()){
                read.createNewFile();
                p.setProperty("count","null");
                fos = new FileOutputStream(read);
                p.store(fos,"how many times does the procedure can run");
            }else {
                fis = new FileInputStream(read);
                p.load(fis);
                String count = p.getProperty("count");
                if ("null".equals(count)){
                    p.setProperty("count","0");
                    fos = new FileOutputStream(read);
                    p.store(fos,"how many times does the procedure can run");
                } else{
                    if (Integer.parseInt(count)>=3){
                        System.out.println("程序使用次数已满，请续费");
                        return;
                    } else{
                        p.setProperty("count",Integer.parseInt(count)+1+"");
                        fos = new FileOutputStream(read);
                        p.store(fos,"how many times does the procedure can run");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos!=null)
                    fos.close();
                if (fis!=null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

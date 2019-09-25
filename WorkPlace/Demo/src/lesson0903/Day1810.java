package lesson0903;

import java.io.*;

public class Day1810 {
    public static void main(String[] args) {
        File d1 = new File("c:/d1");
        d1.mkdir();
        File d2 = new File("c:/d2");
        d2.mkdir();
        File d3 = new File("c:/d3");
        d3.mkdir();
        try {
            for (int i = 0; i < 5; i++) {
                new File(d1.getAbsolutePath(),i+".txt").createNewFile();
            }
            for (File txt : d1.listFiles()){
                FileWriter fw = new FileWriter(new File(d1,txt.getName()));
                fw.write("HELLO WORLD");
                fw.close();
            }
            //字符流复制文件
            for (File txt : d1.listFiles()) {
                File f = new File(d2, txt.getName());
                f.createNewFile();
                FileWriter fw = new FileWriter(f);
                int len;
                FileReader fr = new FileReader(txt);
                while((len = fr.read())!=-1){
                    fw.write(len);
                }
                fw.close();
                fr.close();
            }
            //字节流复制文件
            for (File txt : d1.listFiles()) {
                File f = new File(d3, txt.getName());
                FileInputStream fis = new FileInputStream(txt);
                int len;
                byte[] bytes = new byte[1028*8];
                FileOutputStream fos = new FileOutputStream(f);
                while((len = fis.read(bytes))!=-1){
                    fos.write(bytes,0,len);
                }
                fos.close();
                fis.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

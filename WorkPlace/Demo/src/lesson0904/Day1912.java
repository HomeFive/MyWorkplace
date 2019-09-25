package lesson0904;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Day1912 {
    public static void main(String[] args) {
        FileWriter fw = null;
        FileReader fr = null;
        try {
            fw = new FileWriter("d:/1/蜀相.txt");
            fw.write("蜀相\n");
            fw.write("杜甫\n\n");
            fw.write("丞相祠堂何处寻，锦官城外柏森森。\n");
            fw.write("映阶碧草自春色，隔叶黄鹂空好音。\n");
            fw.write("三顾频频天下计，两朝开济老臣心。\n");
            fw.write("出事未成身先死，长使英雄泪满襟。");
            fw.flush();
            fr = new FileReader("d:/1/蜀相.txt");
            fw = new FileWriter("d:/1/蜀相.txt2");
            for (int line;(line=fr.read())!=-1;)
                fw.write((char)line);
            fw.flush();
            fr = new FileReader("d:/1/蜀相.txt2");
            for (int line;(line=fr.read())!=-1;)
                System.out.print((char)line);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

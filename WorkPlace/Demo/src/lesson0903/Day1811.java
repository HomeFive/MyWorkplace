package lesson0903;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day1811 {
    public static void main(String[] args) {
        System.out.println("请输入要查询的字符：");
        countChar(new Scanner(System.in).next().charAt(0));
    }
    static void countChar(char c){
        FileInputStream fis = null;
        Map<Character,Integer> map = new HashMap<>();
        try {
            fis= new FileInputStream("d:/RetroSnake.html");
            int n = 0;
            int len;
            while ((len=fis.read())!=-1)
                if (len==c)
                    n++;
            System.out.println(c+"出现"+n+"次");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

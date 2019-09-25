package lesson0904;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day1904 {
    public static void main(String[] args) {
        BufferedWriter bw = null;
        BufferedReader br = null;
        Scanner s = new Scanner(System.in);
        try {
            bw = new BufferedWriter(new FileWriter("d:/1/data.txt"));
            System.out.println("请输入3行字符作为验证码...");
            for (int i = 0; i < 3; i++){
                bw.write((s.nextLine()+"\r\n"));
                bw.flush();
            }
            List<String> words = new ArrayList<>();
            br = new BufferedReader(new FileReader("d:/1/data.txt"));
            for (String l="";(l=br.readLine())!=null;){
                words.add(l);
            }
            System.out.println("请输入验证码：");
            String input = s.nextLine();
            boolean match = false;
            for (String word: words)
                if (input.equals(word)){
                    System.out.println("验证码正确");
                    match = true;
                }
            if (!match)
                System.out.println("验证码错误，程序结束");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

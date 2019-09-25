package lesson0903;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Day1809 {
    public static void main(String[] args) {
        System.out.println("请输入学生信息，格式为\"学号-学生名字\":");
        Scanner s = new Scanner(System.in);
        String line = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("d:/1/stu.txt");
            while (!"end".equals(line = s.nextLine()))
                fos.write((line+"\r\n").getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("程序执行结束");
        }
    }
}
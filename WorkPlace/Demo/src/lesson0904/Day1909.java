package lesson0904;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Day1909 {
    public static void main(String[] args) {
        PrintStream ps = null;
        try {
            ps = new PrintStream(new FileOutputStream("d:/1/printstream.txt"));
            /*System.setOut(ps);
            System.out.println(new Scanner(System.in).nextLine());*/
            ps.print(new Scanner(System.in).nextLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            ps.close();
        }
    }
}

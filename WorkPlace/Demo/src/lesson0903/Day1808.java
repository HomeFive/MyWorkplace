package lesson0903;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Day1808 {
    public static void main(String[] args) {
        System.out.println("请输入信息：");
        Scanner s = new Scanner(System.in);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("d:/1/Info.txt",true);
            while (true){
                String msg = s.nextLine();
                if ("886".equals(msg))
                    break;
                fos.write((msg+"\r\n").getBytes());
                fos.flush();
            }
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
        }

    }
}

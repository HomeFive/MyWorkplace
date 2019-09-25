package lesson0904;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day1910 {
    public static void main(String[] args) {
        BufferedWriter bw = null;
        BufferedReader br = null;
        try {
            bw = new BufferedWriter(new FileWriter("d:/1/buffered writer.txt"));
            bw.write("我爱小米科技\n123456");
            bw.flush();
            br = new BufferedReader(new FileReader("d:/1/buffered writer.txt"));
            List<String> strs = new ArrayList<>();
            for (String line;(line=br.readLine())!=null;)
                strs.add(line);
            bw = new BufferedWriter(new FileWriter("d:/1/buffered writer.test"));
            Collections.reverse(strs);
            for (String line: strs)
                bw.write(line+"\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

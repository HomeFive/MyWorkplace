package myClass;

import java.io.*;

public class Test {
    public static void main(String[] args) {
        String str = "鎷掔粷璁块棶銆�";
        OutputStreamWriter osw = null;
        try {
            osw = new OutputStreamWriter(new PrintStream("d:/1/charset.txt"), "utf-8");
            osw.write(str);
            osw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

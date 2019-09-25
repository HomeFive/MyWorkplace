package lesson0901;

import java.io.File;

public class Day1705 {
    public static void main(String[] args) {
        File f = new File("c:/a.txt");
        f.delete();
        File f2 = new File("c:/aaa");
        if (f2.list()==null)
            f2.delete();
    }
}

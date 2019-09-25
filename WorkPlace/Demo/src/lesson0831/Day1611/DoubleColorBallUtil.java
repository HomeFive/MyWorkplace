package lesson0831.Day1611;

import java.util.Arrays;
import java.util.Random;

public class DoubleColorBallUtil {
    public static String create() {
        String[] red = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23",
                "24", "25", "26", "27", "28", "29", "30", "31", "32", "33"};
        String[] blue = "01,02,03,04,05,06,07,08,09,10,11,12,13,14,15,16".split(",");
        boolean[] used = new boolean[red.length];
        Random r = new Random();
        String[] all = new String[7];
        for (int i = 0; i < 6; i++) {
            int idx;
            do {
                idx = r.nextInt(red.length);
            } while (used[idx]);
            used[idx] = true;
            all[i] = red[idx];
        }
        all[all.length - 1] = blue[r.nextInt(blue.length)];
        Arrays.sort(all);
        return Arrays.toString(all);
    }
}

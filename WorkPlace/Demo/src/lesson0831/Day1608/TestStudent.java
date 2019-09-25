package lesson0831.Day1608;

import java.util.Arrays;

public class TestStudent {
    public static void main(String[] args) {
        Student[] stus = new Student[]{
                new Student("明",60.2),
                new Student("红",60.0),
                new Student("红红",60.2),
                new Student("民命",70.0),
                new Student("明红",80.5),
                new Student("额外热舞",50.0),
                new Student("实打实",4.0),
        };
        Student tmp;
        for (int i = 0; i < stus.length-2; i++) {
            for (int j = 0; j < stus.length-1-i; j++) {
                if (stus[j].getScore()<stus[j+1].getScore()){
                    tmp = stus[j];
                    stus[j] = stus[j+1];
                    stus[j+1] = tmp;
                }
            }
        }
        Arrays.asList(stus).stream().forEach(
                student -> System.out.println(student.getScore())
        );
    }
}

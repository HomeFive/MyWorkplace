package lesson0904;

import lesson0904.Day1907.Student;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day1911 {
    public static void main(String[] args) {
        List<Student> stus = new ArrayList<>();
        Collections.addAll(stus, new Student("小明",10,"男"),new Student("Maria",20,"female"),new Student("Mario",60,"男"));
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("d:/1/students.txt"));
            for (Student s:stus)
                oos.writeObject(s);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

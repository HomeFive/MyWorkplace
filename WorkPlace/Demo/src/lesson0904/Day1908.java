package lesson0904;

import lesson0904.Day1907.Student;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Day1908 {
    public static void main(String[] args) {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("d:/1/stu.info"));
            Object o = null;
            Student stu = null;
            while ((o = ois.readObject())!=null){
                stu = (Student)o;
                System.out.println(stu.getName()+stu.getAge()+stu.getSex());
            }
        } catch (IOException e) {
            if (e.getClass()!=EOFException.class)
                e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

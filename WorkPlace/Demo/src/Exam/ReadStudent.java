package Exam;

import com.Student;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class ReadStudent {
    public static void main(String[] args) {
        Properties ps = new Properties();
        try {
            ps.load(ReadStudent.class.getResourceAsStream("student.properties"));
            String className = ps.getProperty("className");
            String name = ps.getProperty("name");
            Integer age = Integer.parseInt(ps.getProperty("age"));
            Class stuClass = Class.forName(className);
            Constructor cst = stuClass.getConstructor(String.class, Integer.class);
            com.Student stu = (Student) cst.newInstance(name,age);
            System.out.println(stu.getName()+","+stu.getAge());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

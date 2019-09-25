package lesson0906.Day2105;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class TestA {
    public static void main(String[] args) {
        System.out.println("输入类A的相对路径名，以调用A的方法(A的相对路径名为lesson0906.Day2105.A):");
        String str = new Scanner(System.in).next();
        try {
            Class<?> aClass = Class.forName(str);
            aClass.getDeclaredMethod("showString").invoke(aClass.getDeclaredConstructor().newInstance());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

package lesson0906.Day2103;

import java.lang.reflect.InvocationTargetException;

public class Reflect02 {
    public static void main(String[] args) {
        try {
            Class stuClass = Class.forName("lesson0906.Day2103.Student");
            System.out.println("class for name style");
            stuClass.newInstance();
            System.out.println("constructor style");
            stuClass.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

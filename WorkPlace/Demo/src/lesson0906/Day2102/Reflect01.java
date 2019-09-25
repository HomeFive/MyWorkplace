package lesson0906.Day2102;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Reflect01 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList();
        Class clazz = list.getClass();
        try {
            Method[] ms = clazz.getMethods();
            for (Method m: ms) {
                if ("add".equals(m.getName()))
                    m.invoke(list,"gogo");
            }
            for (Object o: list)
                System.out.println(o);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

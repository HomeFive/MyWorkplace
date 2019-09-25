package lesson0906.Day2111;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunAnno {
    public static void main(String[] args) {
        TestAnno t = new TestAnno();
        Class<? extends TestAnno> ta = t.getClass();
        Method[] ms = ta.getDeclaredMethods();
        try {
            for (Method m:ms){
                if (m.getAnnotation(MyTest.class) instanceof MyTest){
                    m.invoke(t);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

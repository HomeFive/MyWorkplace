package lesson0906.Day2107;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflect06 {
    public static void main(String[] args) {
        Class clazz = Person.class;
        try {
            Person p = (Person)clazz.getDeclaredConstructor(String.class,Integer.TYPE).newInstance("小明",50);
            System.out.println(p.getName()+p.getAge());
            Field age = clazz.getDeclaredField("age");
            age.setAccessible(true);
            age.set(p,30);
            System.out.println(p.getName()+p.getAge());
            Method setName = clazz.getDeclaredMethod("setName",String.class);
            setName.invoke(p,"小丽");
            System.out.println(p.getName()+p.getAge());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}

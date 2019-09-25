package lesson0906.Day2104;

import java.lang.reflect.InvocationTargetException;

public class Reflect03 {
    public static void main(String[] args) {
        try {
            Class<?> showClass = Class.forName("lesson0906.Day2104.Show");
            Show s = (Show) showClass.getDeclaredConstructor().newInstance();
            s.show();
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

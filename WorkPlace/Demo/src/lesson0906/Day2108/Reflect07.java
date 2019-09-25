package lesson0906.Day2108;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class Reflect07 {
    public static void main(String[] args) {
        Properties p = new Properties();
        try {
            p.load(Reflect07.class.getResourceAsStream("DemoClass.properties"));
            String className = p.getProperty("className");
            Class demoClass = Class.forName(className);
            demoClass.getDeclaredMethod("run").invoke(demoClass.getDeclaredConstructor().newInstance());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

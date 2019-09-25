package lesson0906.Day2106;

import java.lang.reflect.Field;

public class Reflect05 {
    public void setProperty(Object obj, String propertyName, Object value){
        Class<?> clazz = obj.getClass();
        try {
            Field property = clazz.getDeclaredField(propertyName);
            property.setAccessible(true);
            property.set(obj,value);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    public Object getProperty(Object obj, String propertyName){
        Class<?> clazz = obj.getClass();
        try {
            Field property = clazz.getDeclaredField(propertyName);
            property.setAccessible(true);
            return property.get(obj);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Reflect05 r = new Reflect05();
        Entity e = new Entity();
        r.setProperty(e,"num",20);
        System.out.println(r.getProperty(e,"num"));
        r.setProperty(e,"str","gg");
        System.out.println(r.getProperty(e,"str"));
    }
}

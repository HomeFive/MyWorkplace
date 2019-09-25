package lesson0906.Day2112;

import java.lang.reflect.Method;

public class ReadBook {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("lesson0906.Day2112.TestAnno2");
            Method[] ms = clazz.getDeclaredMethods();
            for (Method m:ms){
                if (m.isAnnotationPresent(Book.class)){
                    Book book = m.getAnnotation(Book.class);
                    String value = book.value();
                    double price = book.price();
                    String[] authors = book.authors();
                    System.out.println(value);
                    System.out.println(price);
                    for (String author:authors)
                        System.out.println(author);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

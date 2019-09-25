package lesson0904.Day1907;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TestStudent {
    @Test
    public void testStudent(){
        Student s = new Student("小明",10,"男");
        Student s2 = new Student("mary",12,"female");
        Student s3 = new Student("Dragon·李",12,"male");
        ObjectOutputStream ois = null;
        try {
            ois = new ObjectOutputStream(new FileOutputStream("d:/1/stu.info"));
            ois.writeObject(s);
            ois.writeObject(s2);
            ois.writeObject(s3);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

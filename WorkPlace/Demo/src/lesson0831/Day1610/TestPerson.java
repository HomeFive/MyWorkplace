package lesson0831.Day1610;

import java.util.Random;

public class TestPerson {
    public static void main(String[] args) {
        Person p = new Person();
        //TestPerson tp = new TestPerson();
        DoPerson dp = new DoPerson(p);
        new Thread(()->{
            while (true){
                synchronized (dp){
                    if (dp.set){
                        try {
                            dp.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    dp.set();
                    dp.set=true;
                    dp.notify();
                }
            }
        }).start();
        new Thread(()->{
            while (true){
                synchronized (dp){
                    if (!dp.set){
                        try {
                            dp.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    dp.print();
                    dp.set=false;
                    dp.notify();
                }
            }
        }).start();
    }
}
class DoPerson{
    Person p;
    boolean set = false;
    public DoPerson(Person p) {
        this.p = p;
    }

    public void set() {
        p.setName((char)(new Random().nextInt(2000+0x6000))+"");
        int i = new Random().nextInt(3);
        p.setSex(i==1?"男":i==2?"女":"人妖");
        System.out.println("赋值");
    }
    public void print() {
        if ("人妖".equals(p.getSex()))
            System.out.println("不允许打印人妖");
        else
            System.out.println(p.getName()+"is a "+p.getSex());
    }
}

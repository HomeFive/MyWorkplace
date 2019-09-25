package lesson0830;

import java.util.Random;

public class Day1505 {
    public static void main(String[] args) {
        Day1505 d = new Day1505();
        Person p = d.new Person();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            new Thread(p,"阿"+(char)(r.nextInt(0x9fa5-0x4e00+1)+0x4e00)).start();
        }
    }
    class Person implements Runnable{
        void passing(){
            System.out.println(Thread.currentThread().getName()+"在山洞口");
            try {
                Thread.sleep(1000*1);
                System.out.println(Thread.currentThread().getName()+"在过山洞");
                Thread.sleep(500);
                System.out.println("...");
                Thread.sleep(500);
                System.out.println("...");
                Thread.sleep(1000*1);
                System.out.println(Thread.currentThread().getName()+"过了");
                System.out.println();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void run() {
            synchronized (this) {
                passing();
                notifyAll();
            }
        }
    }
}

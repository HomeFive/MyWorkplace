package lesson0830;

import java.util.Random;

public class Day1506 {
    public static void main(String[] args) {
        Day1506 d = new Day1506();
        /*Cup c = d.new Cup();
        new Thread(c,"实体店").start();
        new Thread(c,"官网").start();*/
        new MyThread2("实体店").start();
        new MyThread2("官网").start();
    }
    class Cup implements Runnable{
        int num = 100;
        @Override
        public void run() {
            while(num>0){
                synchronized (Cup.class) {
                    if (num>0)
                        System.out.println(Thread.currentThread().getName()+"卖出第"+(100-(--num))+"个，总共剩"+num+"个..");
                }
            }
        }
    }
}
class MyThread2 extends Thread{
    static int num=100;
    int selt;

    public MyThread2(String name) {
        super(name);
    }

    @Override
    public void run() {
        while(true){
            synchronized (MyThread2.class) {
                if (num>0){
                    selt++;
                    System.out.println(Thread.currentThread().getName()+"卖出第"+(100-(--num))+"个，总共剩"+num+"个..");
                }
                else{
                    System.out.println(Thread.currentThread().getName()+"共卖出了"+selt+"个");
                    break;
                }
            }
        }
    }
}
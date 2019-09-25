package lesson0830;

public class Day1507 {
    public static void main(String[] args) {
        Day1507 d = new Day1507();
        Car c = d.new Car();
        new Thread(c,"前门").start();
        new Thread(c,"中门").start();
        new Thread(c,"后门").start();
    }
    class Car implements Runnable{
        int num = 80;
        @Override
        public void run() {
            while(num>0){
                synchronized (Car.class) {
                    if (num>0)
                        System.out.println(Thread.currentThread().getName()+"上车---还剩"+--num+"个座...");
                }
            }
        }
    }
}
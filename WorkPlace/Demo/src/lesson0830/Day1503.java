package lesson0830;

public class Day1503 {

    class MyThread extends Thread{
        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println(getName());
        }
    }
    class RunnableImpl implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        Day1503 d = new Day1503();

        System.out.println(Thread.currentThread().getName());

        MyThread m = d.new MyThread("MyThread");
        m.start();

        Thread t = new Thread(d.new RunnableImpl(),"RunnableImpl");
        t.start();
    }
}

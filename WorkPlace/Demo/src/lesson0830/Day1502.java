package lesson0830;

public class Day1502 {
    public static void main(String[] args) {
        Day1502 d = new Day1502();
        MyThread m1 = d.new MyThread();
        Thread t1 = new Thread(d.new RunnableImpl());
        Thread t2 = new Thread(){
            @Override
            public void run() {
                System.out.println("no name inner class style 1");
            }
        };
        Thread t3 = new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("no name inner class style 2");
            }
        });
        m1.start();
        t1.start();
        t2.start();
        t3.start();
    }
    private class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("MyThread");
        }
    }
    private class RunnableImpl implements Runnable{
        @Override
        public void run() {
            System.out.println("runnable IMPL");
        }
    }
}

package lesson0830;

public class Day1508 {
    public static void main(String[] args) {
        new Ticket("窗口a").start();
        new Ticket("窗口b").start();
        new Ticket("窗口c").start();
        new Ticket("窗口d").start();
    }
}
class Ticket extends Thread{
    static int num = 20;

    public Ticket(String name) {
        super(name);
    }

    @Override
    public void run() {
        while(num>0){
            synchronized (Ticket.class) {
                if (num>0)
                    System.out.println(Thread.currentThread().getName()+"卖了一张票，剩余票数为"+--num);
            }
        }
    }
}

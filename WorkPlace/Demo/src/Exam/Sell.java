package Exam;

public class Sell {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread t1 = new Thread(ticket,"A");
        Thread t2 = new Thread(ticket,"B");
        Thread t3 = new Thread(ticket,"C");
        t1.start();
        t2.start();
        t3.start();
    }
}
class Ticket implements Runnable{
    int n = 100;
    int window = 1;

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Ticket.class) {
                if (n > 0)
                    System.out.println(Thread.currentThread().getName() + "窗口正在卖第" + (100 - (--n)) + "张票，剩余" + n + "张。");
                else
                    break;
            }
        }
    }
}
package lesson0831;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Day1604 {
    public static void main(String[] args) {
        Day1604 d = new Day1604();
        ExecutorService es = Executors.newFixedThreadPool(3);
        int sum=0;
        es.submit(d.new Calculate(10));
        es.submit(d.new Calculate(5));
        es.submit(d.new Calculate(8));
        es.shutdown();
    }
    class Calculate implements Runnable{
        int n;

        public Calculate(int n) {
            this.n = n;
        }
        @Override
        public void run() {
            int a=1;
            for (int i = 1; i <= n; i++) {
                a*=i;
            }
            System.out.println(n+"!的计算结果是"+a);
        }
    }
}

package lesson0831;


import java.util.Random;
import java.util.concurrent.*;

public class Day1603 {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);
        int sum=0;
        for (int i = 0; i < 10; i++) {
            try {
                int n = (int)(es.submit(new RandomR()).get());
                System.out.print(n+" ");
                sum += n;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("\n10个1-100的随机数的和的平均数是"+sum/10);
        es.shutdown();
    }
}
class RandomR implements Callable {
    @Override
    public Object call() throws Exception {
        return new Random().nextInt(100)+1;
    }
}

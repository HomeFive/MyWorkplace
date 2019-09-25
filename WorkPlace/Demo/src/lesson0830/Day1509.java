package lesson0830;

public class Day1509 {
    public static void main(String[] args) {
        Day1509 d = new Day1509();
        d.new Calculate(10).start();
        d.new Calculate(5).start();
        d.new Calculate(8).start();
    }
    class Calculate extends Thread{
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

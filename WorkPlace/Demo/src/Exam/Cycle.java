package Exam;

public class Cycle {
    public static void main(String[] args) {
        System.out.println("5!计算结果是"+cycle(5));
    }
    public static int cycle(int n){
        if (n==1)
            return 1;
        return n*cycle(--n);
    }
}

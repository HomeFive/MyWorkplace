package lesson0901;

import java.util.Scanner;

public class Day1710 {
    public static void main(String[] args) {
        System.out.println("输入1-10之间的整数，计算这个数的阶乘：");
        int i = new Scanner(System.in).nextInt();
        if (i<=10)
            System.out.println(mul(i));
        else
            System.out.println("输入错误");
    }
    public static int mul(int n){
        if (n==1)
            return 1;
        return n*mul(--n);
    }
}

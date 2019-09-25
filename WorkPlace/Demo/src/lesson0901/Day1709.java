package lesson0901;

import java.util.Scanner;

public class Day1709 {
    public static void main(String[] args) {
        System.out.println("输入100-200之间的整数，计算1至这个数之间的整数和：");
        int i = new Scanner(System.in).nextInt();
        if (i>=100 && i<=200)
            System.out.println(sum(i));
        else
            System.out.println("输入错误");
    }
    public static int sum(int n){
        if (n==1)
            return 1;
        return n+sum(--n);
    }
}

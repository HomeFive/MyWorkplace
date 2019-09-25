package lesson0830;

public class ChineseWord {
    //nextInt(0x9fa5-0x4e00+1)+0x4e00;
    public static void main(String[] args) {
        for (int i = 0x4e00; i < 0xedd5-0x4e00+1; i++) {
            System.out.print((char)i+" ");
            if (i%16==0)
                System.out.println();
        }
    }
}

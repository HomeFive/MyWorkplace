package lesson0831.Day1611;

import java.util.Random;

public class TestRedBlue {
    public static void main(String[] args) {
        Meeting front = new Meeting("前门");
        Meeting back = new Meeting("后门");
        front.start();
        back.start();
    }
}

class Meeting extends Thread{
    static boolean enter[];
    static int num = 100;
    Random r;
    int sum = 0;

    public Meeting(String name) {
        super(name);
        enter = new boolean[100];
        r = new Random();
    }

    @Override
    public void run() {
        while (true){
            if (num-->0){
                int id;
                do {
                    id = r.nextInt(enter.length);
                }while(enter[id]);
                enter[id] = true;
                System.out.println("编号为:"+id+"的员工 从"+Thread.currentThread().getName()+
                        " 入场！拿到的双色球彩票号码是："+DoubleColorBallUtil.create());
                sum++;
            }
            if (num==0){
                System.out.println("从"+Thread.currentThread().getName()+"入场的员工总共："+sum+"位员工");
                break;
            }
        }
    }
}
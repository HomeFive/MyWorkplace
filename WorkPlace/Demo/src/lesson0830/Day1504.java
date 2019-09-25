package lesson0830;

public class Day1504 {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                System.out.println("播放背景音乐");
            }
        }.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("显示画面");
            }
        }).start();
    }
}

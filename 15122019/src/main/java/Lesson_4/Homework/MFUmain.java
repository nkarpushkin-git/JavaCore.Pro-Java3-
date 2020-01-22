package Lesson_4.Homework;

public class MFUmain {
    public static void main(String[] args) {

        MFU mfu = new MFU();
        String wel = "welcome";
        String hllo = "document";

        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.print(wel, 3);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.scan(hllo, 5, 1);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.scan(wel, 4, 2);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.scan(hllo, 10, 1);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                mfu.print(wel, 3);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                mfu.scan(hllo, 5, 1);
            }
        }).start();



    }
}

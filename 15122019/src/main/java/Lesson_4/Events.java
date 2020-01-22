package Lesson_4;

public class Events {

    public static void main(String[] args) {
        Object chair1 = new Object();
        Object chair2 = new Object();

        Thread hum1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Чел1 подошел к стулу 1");
                synchronized (chair1) {
                    System.out.println("Чел1 сел на стул 1");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Чел1 встал со стула 1");
                }
            }
        });
        hum1.start();

        Thread hum2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Чел2 подошел к стулу 1");
                synchronized (chair1) {
                    System.out.println("Чел2 сел на стул 1");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Чел2 встал со стула 1");
                }
            }
        });
        hum2.start();

        Thread hum3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Чел3 подошел к стулу 2");
                synchronized (chair2) {
                    System.out.println("Чел3 сел на стул 2");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Чел3 встал со стула 2");
                }
            }
        });
        hum2.start();
    }
}

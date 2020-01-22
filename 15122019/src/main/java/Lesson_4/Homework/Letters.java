package Lesson_4.Homework;

import java.io.IOException;

public class Letters {
    static Object obj = new Object();
    static volatile char letter = 'A';

    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    for (int i = 0; i < 5; i++) {
                        synchronized (obj) {
                            while (letter != 'A') {
                                obj.wait();
                            }

                            System.out.println("A");
                            letter = 'B';
                            obj.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 5; i++){
                        synchronized (obj) {
                            while (letter != 'B') {
                                obj.wait();
                            }

                            System.out.println("B");
                            letter = 'C';
                            obj.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 5; i++){
                        synchronized (obj) {
                            while (letter != 'C') {
                                obj.wait();
                            }

                            System.out.println("C");
                            letter = 'A';
                            obj.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

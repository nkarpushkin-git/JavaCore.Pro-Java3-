package Lesson_5.HW.Lesson_5;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    Semaphore smp = new Semaphore(2);
         public Tunnel() {
             this.length =  80 ;
             this.description = "������� " + length + " ������";
        }

                @Override
            public void go(Car c) {

             try {
                try {
                    System.out.println(c.getName() + " ��������� � �����(����): " + description);
                    smp.acquire();
                    System.out.println(c.getName() + " ����� ����: " + description);
                    Thread.sleep(length / c.getSpeed() * 1000 );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(c.getName() + " �������� ����: " + description);
                    smp.release();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
     }
}



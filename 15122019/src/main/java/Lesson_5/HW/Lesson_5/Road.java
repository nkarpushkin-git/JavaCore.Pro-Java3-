package Lesson_5.HW.Lesson_5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Road extends Stage {

         public Road(int length) {
         this.length = length;
         this.description = "������ " + length + " ������" ;
        }
         @Override 
     public void go(Car c) {
             try {
                 System.out.println(c.getName() + " ����� ����: " + description);
                 Thread.sleep(length / c.getSpeed() * 1000);
                 System.out.println(c.getName() + " �������� ����: " + description);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
}



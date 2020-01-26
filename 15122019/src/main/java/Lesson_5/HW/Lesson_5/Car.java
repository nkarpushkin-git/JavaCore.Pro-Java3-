package Lesson_5.HW.Lesson_5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable  {
    CyclicBarrier cb = new CyclicBarrier(MainClass.CARS_COUNT);

         private static int CARS_COUNT;
         static {
            CARS_COUNT =  0 ;
        }
         private Race race;
         private int speed;
         private String name;

         public String getName() {
            return name;
        }

         public int getSpeed () {
            return speed;
        }

         public Car(Race race, int speed) {
             this.race = race;
             this.speed = speed;
            CARS_COUNT++;
             this.name = "�������� #" + CARS_COUNT;
        }
         @Override 
        public void run() {
             try {
                System.out.println( this.name + " ���������" );
                Thread.sleep(500  + (int)(Math.random() * 800 ));
                System.out.println(this.name + " �����");
             try {
                 cb.await();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             } catch (BrokenBarrierException e) {
                 e.printStackTrace();
             }
             } catch(Exception e) {
                e.printStackTrace();
             }


             for (int i = 0 ; i < race.getStages().size(); i++) {
        race.getStages().get(i).go( this );
            }
     }
}
package Lesson_5.HW.Lesson_5;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MainClass {
        public static final int CARS_COUNT = 4;
        public static void main(String[] args) {
            CountDownLatch cdl = new CountDownLatch(CARS_COUNT);
            CyclicBarrier cb = new CyclicBarrier(CARS_COUNT+1);


            System.out.println("������ ���������� >>> ����������!!!");
            Race race = new Race(new Road(60), new Tunnel(), new Road(40));
            Car[] cars = new Car[CARS_COUNT];

            for (int i = 0; i < cars.length; i++) {
                cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
            }
//            cdl.countDown();

            for (int i = 0; i < cars.length; i++) {
                new Thread(cars[i]).start();
            }
//

//
//            try {
//                cb.await();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (BrokenBarrierException e) {
//                e.printStackTrace();
//            }

            //            try {
//                cdl.await();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println("������ ���������� >>> ����� ��������!!!");
//            cdl.countDown();


//            try {
//                cdl.await();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println("������ ���������� >>> ����� �����������!!!");
        }
}





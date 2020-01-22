package Lesson_4.Homework;

import java.io.*;

public class MFU {
    Object printSync = new Object();
    Object scanSync = new Object();

        public void print(String pdf, int num) {
            synchronized (printSync) {
                System.out.println("Идет печать документа...");
                for (int i = 0; i < num; i++) {
                    System.out.println(i + " " + pdf);
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("...конец печати");
            }
        }

        public void scan(String doc, int n, int source)  {
            synchronized (scanSync){
                switch (source) {
                    case 1:
                        System.out.println("идет сканирование в сеть...");
                        for (int i = 0; i < n; i++)
                            System.out.println(i + " " + doc);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("...конец сканирования в сеть");

                    case 2:
                        System.out.println("идет копирование...");
                        for (int i = 0; i < n; i++) {
                            synchronized (scanSync) {
                                System.out.println(i + " " + doc);
                                print(doc, n);

                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        System.out.println("...конец копирования");
                }
            }

        }
    }



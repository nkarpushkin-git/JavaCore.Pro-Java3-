package Lesson_3.Homework.HW;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class Task3 {
    public static long t1;
    public static void main(String[] args) {


        long t = System.currentTimeMillis();



        try (FileInputStream in = new FileInputStream("files/stories.txt")) {
            byte[] arr = new byte[1800];
            int x;
            t1 = (System.currentTimeMillis() - t);
            while ((x = in.read(arr)) != -1) {
                System.out.print(new String(arr, 0, x, "UTF-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//
        long t2 = (System.currentTimeMillis() - t);
        System.out.println("\n Время загрузки: " + t1 + " милисекунд");
        System.out.println("\n Время выполения: " + t2 + " милисекунд");


//        ArrayList<InputStream> al = new ArrayList<>();
//
//        try {
//            for (int i = 0; i < 1000; i++) {
//            al.add(new FileInputStream("files/scratch.txt"));
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        Enumeration<InputStream> e = Collections.enumeration(al);
//
//        SequenceInputStream seqIn = new SequenceInputStream(e);
//
//        int x;
//
//
//        try {
//            FileOutputStream out = new FileOutputStream("files/stories.txt");
//            while ((x = seqIn.read()) != -1) {
//                System.out.print((char) x);
//                out.write((char) x);
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }


    }
}

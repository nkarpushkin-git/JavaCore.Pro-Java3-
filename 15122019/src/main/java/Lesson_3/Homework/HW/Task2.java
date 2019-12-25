package Lesson_3.Homework.HW;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class Task2 {
    public static void main(String[] args) {


        ArrayList<InputStream> al = new ArrayList<>();

        try {
            al.add(new FileInputStream("files/seq1.txt"));
            al.add(new FileInputStream("files/seq2.txt"));
            al.add(new FileInputStream("files/seq3.txt"));
            al.add(new FileInputStream("files/seq4.txt"));
            al.add(new FileInputStream("files/seq5.txt"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Enumeration<InputStream> e = Collections.enumeration(al);

        SequenceInputStream seqIn = new SequenceInputStream(e);

        int x;


        try {
            FileOutputStream out = new FileOutputStream("files/seqOut.txt");
            while ((x = seqIn.read()) != -1) {
                System.out.print((char) x);
                out.write((char) x);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }


//        try {
//            FileOutputStream out = new FileOutputStream("files/seqOut.txt"); {
////
//                while (true) {
//                    e.nextElement();
//                    out.write(() e);
//                }
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }

    }
}

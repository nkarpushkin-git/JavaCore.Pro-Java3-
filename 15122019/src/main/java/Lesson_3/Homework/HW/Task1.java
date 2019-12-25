package Lesson_3.Homework.HW;

import java.io.*;

public class Task1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException{

        byte[] bfr = new byte[50];

        try (FileInputStream in = new FileInputStream("files/file-50b.txt")) {
            int count;
            while ((count = in.read(bfr)) > 0) {
                for (int i = 0; i < count; i++) {
                    System.out.print((char) bfr[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("");

        try (FileInputStream in = new FileInputStream("files/file-50b.txt")) {
            int count;
            while ((count = in.read(bfr)) > 0) {
                for (int i = 0; i < count; i++) {
                    System.out.print( bfr[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

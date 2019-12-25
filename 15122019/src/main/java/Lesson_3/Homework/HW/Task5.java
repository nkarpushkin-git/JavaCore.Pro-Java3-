package Lesson_3.Homework.HW;

import java.io.FileInputStream;
import java.io.IOException;

public class Task5 {
    public static void main(String[] args) {
        byte[] bfr = new byte[50];

        try (FileInputStream in = new FileInputStream("files/file-50b.txt")) {
            int count;
            while ((count = in.read(bfr)) > 0) {
                for (int i = (count-1); i > -1; i--) {
                    System.out.print((char) bfr[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

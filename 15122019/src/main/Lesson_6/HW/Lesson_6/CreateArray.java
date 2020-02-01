package Lesson_6.HW.Lesson_6;

import java.util.ArrayList;
import java.util.Random;

public class CreateArray {

    public int[] arrFullfill (int[] arrs){
        Random random = new Random();
        System.out.println("Сгенерирован массив " + this + ": ");
        for (int i = 0; i < arrs.length; i++) {
            arrs[i] = Integer.parseInt(String.valueOf((Math.random()*10)));
            System.out.println(arrs[i]);
        }
        return arrs;
    }

}

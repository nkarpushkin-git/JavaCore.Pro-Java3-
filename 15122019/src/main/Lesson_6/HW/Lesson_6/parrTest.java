package Lesson_6.HW.Lesson_6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class parrTest {
    @Parameterized.Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 1, 5, 3, 4, 9, 1, 4, 6},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 5, 6, 7, 8, 4, 9}
        });
    }



    private Array arr;
    private int a;
    private int b;
//    private int c;

//    public ArrMassCh(int a, int b) {
//        this.a = a;
//        this.b = b;
//        this.c = c;
//    }



//    @Before
//    public void init() {
//        arr = new Arr();
//    }

//    @Test
//    public void massTest() {
//        Assert.assertEquals(c, calc.add(a,b));
//    }

}

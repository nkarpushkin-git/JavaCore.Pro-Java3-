package Lesson_2;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {
}

///////// 1
//interface I1 {
//    void copy() throws IOException;
//}
//
//interface I2 {
//    void copy() throws FileNotFoundException;
//}
//
//
//class A implements I1, I2 {
//
//    // вопрос: какие исключения нужно использовать и нужно ли?
//    @Override
//    public void copy() {
//
//    }
//}














//////////// 2

class Main {
    public static void main(String[] args) {
        System.out.print(Values.A);
    }
}

enum Values {
    A(1), B(2), C(3);

    Values(int i) {
        System.out.print(i);
    }

    static  {
        System.out.print("static");
    }
}












////////// какой будет результат


class equalsLong {
    public static void main(String[] args) {
        Long a = 111L;
        Long b = 111L;
        Long c = 222L;
        Long d = 222L;

        System.out.println(a == b);
        System.out.println(c == d);
    }
}











class Test4{
//    public static void main(String[] args) {
//            System.out.println(11/0);
//    }

//   public static void main(String[] args) {
//        double d1 = 11./0;
//        double d2 = 15./0;
//        System.out.println(d1);
//        System.out.println(d2);
//        System.out.println(d1 - d2);
//   }
}

//
//        public static void main(String[] args) {
//            System.out.println(11/0);
//        }

















//
//        public static void main(String[] args) {
//            double d1 = 11./0;
//            double d2 = 15./0;
//            System.out.println(d1);
//            System.out.println(d2);
//            System.out.println(d1 - d2);
//        }
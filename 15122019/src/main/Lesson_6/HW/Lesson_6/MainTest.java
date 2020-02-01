package Lesson_6.HW.Lesson_6;

public class MainTest {
    public static void main(String[] args) {

        int[] arr0 = {1,2,5,4,6,5,8,5,6,8};
        int[] arr1 = {4,5,7,4,4,5,2};
        int[] arr2 = {2,6,9,4,6,9,5,68,4,5,5,8,4,5};
        int[] arr3 = {7,8,3,5,6,9,6,21,64,74,1,4,3,4,8,2,3,6,8,514,1};


        arrCutter(arr0);
        arrCutter(arr1);
        arrCutter(arr2);
        arrCutter(arr3);
    }

    private static Integer[] arrCutter(int[] arrs) {
        int tmp = 0;
        for (int i = 0; i < arrs.length ; i++) {
            if (arrs[i] == 4) {
                tmp = i;
            }
        }
        Integer[] tmpArr = new Integer[arrs.length - (tmp + 1)];
        int j = 0;
        for (int i = (tmp+1); i < arrs.length; i++) {
                tmpArr[j] = arrs[i];
                j++;
        }
        for (int i = 0; i < tmpArr.length; i++) {
            System.out.print(tmpArr[i] + " ");
        }
        System.out.println("");
        return tmpArr;
    }
}

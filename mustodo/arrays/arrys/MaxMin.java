package mustodo.arrays.arrys;

import java.util.Arrays;

public class MaxMin {
    public static void main(String[] args) {
        //int a [] = {1,2,3,4,5,6};

        int a [] = {1, 2, 3, 4, 5, 6, 7};
        //110, 10 ,100 ,20 ,90, 30 ,80 ,40, 70 ,50, 60

        int length =a.length;
        for(int i=0;i<a.length;i=i+2){
            int temp = a[length-1];
            shiftRight(a,i);
            a[i]= temp;
        }
        Arrays.stream(a).forEach(e-> System.out.print(e+","));
    }

    private static void shiftRight(int[] a,int index) {
        // prev =1
        // temp =2
        // a = prev
        //prev = temp

        int prev = a[index];
        for(int i=index+1;i<a.length;i++){
            int temp = a[i];
            a[i] = prev;
            prev = temp;
        }
    }
}

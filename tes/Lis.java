package tes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lis {

    public static void main(String[] args) {
       // int []a = { 10, 22, 9, 33, 21, 50, 41, 60 };
        int []a = {3, 10, 2, 11};

        lisN2(a);
        lisDP(a);
    }

    private static void lisDP(int[] a) {
        int temp[] = new int[a.length];
        Arrays.fill(temp,1);

        for(int i=1;i<a.length;i++){
            if(a[i]>a[i-1]){
                temp[i] = temp[i-1] +1;
            }else{
                temp[i] = temp[i-1];
            }
        }

        Arrays.sort(temp);
        System.out.println(temp[temp.length-1]);

    }

    private static void lisN2(int[] a) {
        int max_length=0;
        for(int i=0;i<a.length;i++){
            int length = findLocalLis(a,i);
            if(length>max_length){
                max_length = length;
            }
        }

        System.out.println(max_length);
    }

    private static int findLocalLis(int[] a, int index) {
        int num = a[index];

        List<Integer> list = new ArrayList<>();
        list.add(num);
        for(int i=index+1;i<a.length;i++){
            if(a[i] >num){
                num = a[i];
                list.add(a[i]);
            }
        }

       // System.out.println(list);
        return list.size();
    }
}

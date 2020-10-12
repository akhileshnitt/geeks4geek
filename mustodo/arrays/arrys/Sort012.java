package mustodo.arrays.arrys;

import java.util.Arrays;

public class Sort012 {

    public static void main(String[] args) {
        int a [] ={0, 2, 1, 2 ,0};
        Arrays.sort(a);

        Arrays.stream(a).forEach(e-> System.out.print(e+","));

        System.out.println("sort array");

        int count0=0,count1=0;
        for(int i=0;i<a.length;i++){
            if(a[i]==0) count0++;
            else if(a[i] ==1) count1++;
        }
        int j=0;
        int remaining = a.length-count0-count1;
        while(count0 >0){
            a[j++] = 0;
            count0--;
        }
        while(count1 >0){
            a[j++] = 1;
            count1--;
        }

        while (remaining>0){
            a[j++] = 2;
            remaining--;

        }
        Arrays.stream(a).forEach(e-> System.out.print(e+","));
    }
}

package mustodo.arrays.arrys;

import java.util.Arrays;

public class Platform {

    public static void main(String[] args) {
        int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
        //int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
        int dep []= {910,1120,1130,1200,1900,2000};

        Arrays.sort(arr);
        Arrays.sort(dep);

        int i=0,j=0;
        int max=Integer.MIN_VALUE;
        int count=0;
        while(i<arr.length && j<arr.length){
            if(arr[i] <dep[j]){
                count++;
                i++;
            }else{
                count--;
                j++;
            }
            max = Math.max(max,count);
        }
        System.out.println(max);
    }
}

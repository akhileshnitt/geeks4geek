package array;

import java.util.Arrays;

public class NoOfWaysToReachEnd {

    public static void main(String[] args) {
        int a[] ={3,2,0,1};

        int ways[] = new int[a.length];
        for(int i=0;i<a.length-1;i++){

           if(a[i] !=0) {
               ways[i] = noOfWays(a, i, a.length, 0);
           }
           else {
               ways[i] = -1;
           }
           a[a.length-1] =0;
        }
        System.out.println();

        Arrays.stream(ways).forEach(e-> System.out.print(e+","));
    }

    private static int  noOfWays(int[] a, int index, int length,int count) {

        if(index == length-1){
            return count +1;
        }


        for(int i=1;i<=a[index];i++){
            if(a[i+index] != 0)
            count += noOfWays(a,i+index,length,count);
        }
        return count;

    }
}

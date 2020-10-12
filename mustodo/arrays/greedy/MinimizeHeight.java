package mustodo.arrays.greedy;

import java.util.Arrays;

public class MinimizeHeight {
    public static void main(String[] args) {
        /*int height  [] = {1 ,5 ,8 ,10};
        int k=2;*/

     /*   int height  [] = {3 ,9 ,12, 16, 20};
        int k=3;*/

        int height  [] = {1, 15, 10};
        int k=6;

        Arrays.sort(height);

        int minDiff =  minDiff(height,k);
        System.out.println(minDiff);

    }

    private static int minDiff(int[] height, int k) {

        int min =  Integer.MAX_VALUE;

        // +k
        int temp = Math.abs(height[0]+k - (height[height.length-1]+k));
        if(temp <min){
            min = temp;
        }

        //-k
        temp = Math.abs(height[0]-k - (height[height.length-1]-k));
        if(temp <min){
            min = temp;
        }

        //+k ,-k
        temp = Math.abs(height[0]+k - (height[height.length-1]-k));
        if(temp <min){
            min = temp;
        }

        //-k,+k
        temp = Math.abs(height[0]-k - (height[height.length-1]+k));
        if(temp <min){
            min = temp;
        }
        return min;
    }
}

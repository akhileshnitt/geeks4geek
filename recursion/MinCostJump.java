package recursion;

public class MinCostJump {

    static int  minCost = Integer.MAX_VALUE;
    public static void main(String[] args) {
      /*  int arr[] = {10,30,40,50,20};
        int k=3;*/

        int arr[] = {40,10,20,70,80,10};
        int k=4;

        int startIndex =0;
        int cost =0;
        int startingIndex =0;
        findMinimumCostJump(arr,startingIndex,startIndex,cost,k,arr.length);
        System.out.println(minCost);
    }


    private static void findMinimumCostJump(int[] arr, int startingIndex,int startIndex, int cost, int k, int length) {

        if(startIndex == length-1){

            if(cost <minCost){

                minCost = cost;
            }
        }


        for(int i=startIndex+1;i<=startIndex+k;i++){
            if(i<length) {
                int tempCost = Math.abs(arr[startIndex] - arr[i]);
                int tCost = cost + tempCost;
                findMinimumCostJump(arr, i, i, tCost, k, length);
            }
        }
    }
}

package recursion;

public class RodCutting {


    static int maxProfitCost = Integer.MIN_VALUE;
    public static void main(String[] args) {

       // int []cost = {0,1  , 5 ,  8, 9,10  ,17 , 17 , 20};
        int []cost = {0,3  , 5 ,  8  , 9  ,10  ,17 , 17 , 20};
        int maxProfit =0;
        int rodLength = cost.length-1;

       // maxProfit = finMaxProfit(rodLength,cost,maxProfit);
       // System.out.println(maxProfit);

        finMaxProfit1(rodLength,"",0,cost);
        System.out.println(maxProfitCost);
    }

    private static void finMaxProfit1(int rodLength,String s,int max,int[] cost) {
        if(rodLength ==0){
            if(max>maxProfitCost){
                maxProfitCost = max;
            }
        //    System.out.println(s +" cost "+max);
            return;
        }

        for(int i=1;i<=rodLength;i++){
            int newRodLength = rodLength -i;
            String newS = s+i+"+";

            int mcost = max+cost[i];

            finMaxProfit1(newRodLength,newS,mcost,cost);

        }
      //  System.out.println();
    }


    private static int  finMaxProfit(int rodLength, int[] cost, int maxProfit) {
        if(rodLength ==0){
            return maxProfit;
        }

        for(int i=1;i<=rodLength;i++){
            maxProfit = maxProfit+cost[i];
            rodLength = rodLength -i;
            int tempProfit = finMaxProfit(rodLength,cost,maxProfit);
            if(tempProfit>maxProfit){
                maxProfit = tempProfit;
            }

        }
        return maxProfit;

    }
}

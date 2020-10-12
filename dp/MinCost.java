package dp;

public class MinCost {
    public static void main(String[] args) {
        /*int N = 9;
        int P =  5;
        int Q = 1;*/

        int N = 7;
        int P = 1;
        int Q = 1;

        int minCost = P+minCost(1,N,P,Q,0);
        System.out.println(minCost);
    }

    private static int minCost(int start, int end, int addCost, int doubleCost,int totalCost) {
        if(start>end){
            return Integer.MAX_VALUE;
        }

        if(start == end){
            return totalCost;
        }

        return Math.min(minCost(start+1,end,addCost,doubleCost,totalCost+addCost),
        minCost(start*2,end,addCost,doubleCost,totalCost+doubleCost));
    }

}

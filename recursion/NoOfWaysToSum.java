package recursion;

import java.util.ArrayList;

public class NoOfWaysToSum {
    static  int noOfWays;

    public static void main(String[] args) {
        int N=3;

       findWays(N,0,new ArrayList<Integer>());

        System.out.println("Nof of ways");
        System.out.println(noOfWays);
    }

    private static void findWays(int n, int sum, ArrayList<Integer> paths) {

        if(sum >n){
            return ;
        }
        if(sum == n){
            noOfWays++;
            paths.forEach(e-> System.out.print(e+","));
            System.out.println();
            return;
        }

        for(int i=1;i<=n;i++){
            paths.add(i);
            findWays(n,sum+i,paths);
            paths.remove(paths.size()-1);
        }

    }

}

package array;

import java.util.ArrayList;
import java.util.List;

public class BuySellStocks {
    public static void main(String[] args) {


    //    atMostKTimes();
        maxProfit();
    }

    private static void maxProfit() {
        int a[] = {100,180,260,310,40,535,695};
        int i=0;

        List<Interval> list = new ArrayList<Interval>();

        while(i<a.length){
            Interval interval = new Interval();
            while (a[i+1] <a[i]){
                i++;
            }
            interval.setBuy(i);
            while(i+1 <a.length && a[i+1]>a[i]){
                i++;
            }
            interval.setSell(i++);
            list.add(interval);

        }


        for(Interval interval:list){
            System.out.println("Buy at "+a[interval.getBuy()] +"  sell at "+a[interval.getSell()]);

        }



    }

    private static void atMostKTimes() {
         int stock [] = {2,5,7,1,4,3,1,3};
        // int stock [] = {10,22,5,75,65,80};
       // int stock [] = {90,80,70,60,50,40};
        int k =5;

        int [][] dp = new int[k+1][stock.length+1];

        int maxDiff = -500;
        for(int i=1;i<k+1;i++){

            for(int j=2;j<stock.length+1;j++){
                 int maxDiff1 = dp[i-1][j-1]- stock[j-2];
                 if(maxDiff1 > maxDiff){
                     maxDiff = maxDiff1;
                 }
                dp[i][j] = Math.max(dp[i][j-1],maxDiff+stock[j-1]);
            }
            maxDiff = -500;
        }


        System.out.println(dp[k][stock.length]);
    }


}

class Interval{
    int buy;
    int sell;

    public Interval() {
    }

    public Interval(int buy, int sell) {
        this.buy = buy;
        this.sell = sell;
    }

    public int getBuy() {
        return buy;
    }

    public void setBuy(int buy) {
        this.buy = buy;
    }

    public int getSell() {
        return sell;
    }

    public void setSell(int sell) {
        this.sell = sell;
    }
}
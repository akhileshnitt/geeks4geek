package mustodo.arrays.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinCandies {
    public static void main(String[] args) {
        int price [] = {3 ,2, 1 ,4};
        int offer = 2;

        List<Integer> priceList = new ArrayList<>();
        Arrays.stream(price).forEach(e->priceList.add(e));
        Collections.sort(priceList);

        minCost(offer, priceList);


        Arrays.stream(price).forEach(e->priceList.add(e));
        Collections.sort(priceList,Collections.reverseOrder());
        System.out.println("MaxCost ");
        minCost(offer, priceList);

    }

    private static void minCost(int offer, List<Integer> priceList) {
        int minCost=0;
        while(priceList.size()>0){
            minCost += priceList.remove(0);
            for(int k=0;k<offer && priceList.size()>0;k++) {
                priceList.remove(priceList.size() - 1);
               // minCost += priceList.remove(priceList.size() - 1-k);

            }
        }
        System.out.println(minCost);
    }
}

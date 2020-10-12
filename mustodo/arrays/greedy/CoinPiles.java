package mustodo.arrays.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class CoinPiles {

    public static void main(String[] args) {
       // 1 5 1 2 5 1    k =2
        // 5 5 2 1 1 1       2 coins
        //5 3 2 1 1 1       2 cooins
        // 3 3 2 1 1 1


        // 1 5 1 2 5 1    k =3
        // 5 5 2 1 1 1    1 coin
        // 4 4 2 1 1 1    1 coin


      /*  int coinPiles [] = {1, 5, 1, 2, 5, 1};
        int k =2;*/

        int coinPiles [] = {2,2,2,2};
        int k =0;

        PriorityQueue<Integer> maxpq = new PriorityQueue<>(coinPiles.length, Collections.reverseOrder());
        PriorityQueue<Integer> minpq = new PriorityQueue<>(coinPiles.length);
        Arrays.stream(coinPiles).forEach(e->maxpq.add(e));
        Arrays.stream(coinPiles).forEach(e->minpq.add(e));

        int totalCoins =0;
        while (!maxpq.isEmpty() && maxpq.peek() - minpq.peek()> k){

                Integer temp = maxpq.poll();

                Integer coins = temp - (temp - minpq.peek());
                totalCoins = totalCoins +coins;
                maxpq.add(temp-coins);

        }

        System.out.println(totalCoins);

    }
}

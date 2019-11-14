package dp;

import java.util.ArrayList;
import java.util.List;

public class CoinChange {
    int count = 0;

    public CoinChange(int count) {
        this.count = count;
    }

    public static void main(String[] args) {
        int sum = 4;
        int input[] = {1, 2, 3};


        CoinChange coinChange = new CoinChange(0);
        List<Integer> combination = new ArrayList<Integer>();
        coinChange.findWays(input, sum, combination);

        //   System.out.println(coinChange.count);
    }

    private void findWays(int[] input, int sum, List<Integer> combination) {
        if (sum == 0) {
            this.count = this.count + 1;
            combination.forEach(e -> System.out.print(e + " "));
            System.out.println();

        }
        for (int i = 0; i < input.length; i++) {
            if (sum - input[i] >= 0) {
                combination.add(input[i]);
                findWays(input, sum - input[i], combination);
            }
            combination.remove(combination.size()-1);
        }

    }


}

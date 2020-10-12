package mustodo.arrays.greedy;

import java.util.Arrays;

public class MaxToys {

    public static void main(String[] args) {
        int  price [] = {1, 12, 5, 111, 200, 1000, 10};
        int amountInHand = 50;
        int  numberOfToys = numberOfToys(price,amountInHand);
        System.out.println(numberOfToys);
    }

    private static int numberOfToys(int[] price, int amountInHand) {
        int numberOfToys =0;

        Arrays.sort(price);

        for(int i=0;i<price.length;i++){
            if(amountInHand - price[i] >0){
                amountInHand = amountInHand - price[i];
                numberOfToys++;
            }
        }

        return numberOfToys;
    }

}

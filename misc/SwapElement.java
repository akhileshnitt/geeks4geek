package misc;

import java.util.Arrays;

public class SwapElement {

    public static void main(String[] args) {
        int a [] = {4, 1, 2, 1, 1, 2};
        int b [] = {3, 6, 3, 3};

        findPair(b, a);
    }

    private static void findPair(int[] b, int[] a) {
        int tempASum = Arrays.stream(a).sum(); // 11
        int tempBSum = Arrays.stream(b).sum(); //15

        int aSum,bSum;
        if(tempBSum >tempASum) {
            bSum = tempBSum;
            aSum = tempASum;
        }
        else{
            aSum=tempBSum;
            bSum=tempASum;
        }


        for(int i=0;i<a.length;i++){
            for(int j=0;j<b.length;j++){
                if(bSum- a[i] == aSum+b[j]){
                    System.out.println(a[i]+" "+b[j]);
                    break;
                }
            }
        }
    }
}

package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Triplet {

    public static void main(String[] args) {
        int [] a = {1,5,3,2};

        // 6 ,4 ,3 8 7 5
        int tripletCount = countTriplet1(a);
        System.out.println(tripletCount);


        // Find a triplet that add to a given value
        int input [] = {12, 3, 4, 1, 6, 9};
        int sum = 24;

       /* int input [] = {1, 2, 3, 4, 5};
        int add = 9;*/

        //a+b+c = add
        // a
        //

      //  findTriplet(input,add);

        findTripletN2(input,sum);

    }

    private static void findTripletN2(int[] input, int sum) {
        for(int i=0;i<input.length;i++){
            int tempSum = sum-input[i];
            // find out pair whose add is tempSum

            Holder holder = findPair(input,i,tempSum);
            if(holder != null){
                System.out.println(input[i]+","+holder.i+","+holder.j);
            }
        }
    }

    static class Holder{
        int i;
        int j;

        public Holder(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    private static Holder findPair(int[] input, int index, int tempSum) {
        // a+b = add
        // a = add-b
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<input.length && i!=index;i++){
            if(!set.contains(tempSum-input[i])){
                set.add(input[i]);
            }
            else{
                return new Holder(input[i],tempSum-input[i]);
            }
        }
        return null;
    }

    private static void findTriplet(int[] input, int sum) {
        for(int i=0;i<input.length;i++){
            for(int j=0;j<input.length;j++){

                for(int k=0;k<input.length;k++){
                    if(input[i]+input[j]+input[k] == sum){
                        if(i!= j && i!=k && j!=k  )
                        System.out.println(input[i]+","+input[j]+","+input[k]);
                    }
                }
            }
        }
    }


    private static int countTriplet1(int[] a) {

        Arrays.sort(a);
        int count =0;
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                for(int k=j+1;k<a.length;k++){
                    if(a[i]+a[j] == a[k]){
                        count++;
                    }
                }
            }
        }

        return count;
    }
}

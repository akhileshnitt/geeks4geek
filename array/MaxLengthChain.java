package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaxLengthChain {

    public static void main(String[] args) {
        //Input: N = 5, arr={{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90} }
        //Output: 3




       // Sort all pairs in increasing order of second number of each pair.
       // Select first no as the first pair of chain and set a variable s(say) with the second value of the first pair.
       //         Iterate from the second pair to last pair of the array and if the value of the first element
        //         of the current pair is greater then previously selected pair then select the current pair and
        //         update the value of maximum length and variable s.
        //        Return the value of Max length of chain.


       // int [][] arr={{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90} };
        int [][] arr= {{5, 24}, {15, 28},{27, 40},{39, 60},{50, 90} };



        List<Pair> pairs = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            int p []= arr[i];
            pairs.add(new Pair(p[0],p[1]));
        }

      //  {5, 24}, {15, 28},{27, 40},{39, 60},{50, 90} };
       // 5,24
        // s = 40



        int maxChain = Integer.MIN_VALUE;


        for(int i=0;i<pairs.size();i++){
            Stack<Pair> stack = new Stack<>();
            stack.push(pairs.get(i));
            for(int j=0;j<pairs.size();j++){
                if(i!=j){
                    Pair pair = stack.peek();
                    Pair temp = pairs.get(j);
                    if(pair.end < temp.start){
                        stack.push(temp);
                    }
                }
                if(stack.size() >maxChain){
                    maxChain = stack.size();

                }
            }
        }

        System.out.println(maxChain);





    }
}

class Pair{
    int start;
    int end;

    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

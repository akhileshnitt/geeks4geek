package misc;

import java.util.Collections;
import java.util.PriorityQueue;

public class RunningMedian {
    public static void main(String[] args) {
        // 5,15,1,3
        // 5 , 10, 5, 4

       // int input[] = {5,15,1,3};
        int input[] = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};

        computeMedian(input);

    }

    private static void computeMedian(int[] input) {

        // left maxheap
        // right minHeap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int median=0;

        for(int i=0;i<input.length;i++){
            if(maxHeap.size() == minHeap.size()){
                if(input[i] <median){
                    maxHeap.add(input[i]);
                    median = maxHeap.peek();
                }else{
                    minHeap.add(input[i]);
                    median = minHeap.peek();
                }
            }
            else if(maxHeap.size() >minHeap.size()){
                if(input[i]<median){
                    minHeap.add(maxHeap.remove());
                    maxHeap.add(input[i]);
                }else {
                    maxHeap.add(minHeap.remove());
                    minHeap.add(input[i]);
                }
                median = (maxHeap.peek()+minHeap.peek())/2;
            }
            else{
                if(input[i] <median){
                    maxHeap.add(input[i]);
                }else {
                    maxHeap.add(minHeap.remove());
                    minHeap.add(input[i]);
                }
                median = (maxHeap.peek()+minHeap.peek())/2;
            }

            System.out.print(median+",");
        }


    }
}

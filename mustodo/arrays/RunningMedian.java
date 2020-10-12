package mustodo.arrays;

import java.util.Collections;
import java.util.PriorityQueue;

public class RunningMedian {


    public static void main(String[] args) {
        int input[] = {2, 4, 1, 5, 6, 7};

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();


        int median = 0;
        for (int i = 0; i < input.length; i++) {

            if (input[i] < median) {
                if (Math.abs(maxHeap.size() - minHeap.size()) > 1) {
                    // swap
                    if (maxHeap.size() > minHeap.size()) {
                        minHeap.add(maxHeap.poll());
                    } else {
                        maxHeap.add(minHeap.poll());
                    }

                } else {
                    maxHeap.add(input[i]);
                }
            } else {

                if (Math.abs(maxHeap.size() - minHeap.size()) > 1) {
                    // swap
                    if (maxHeap.size() > minHeap.size()) {
                        minHeap.add(maxHeap.poll());
                    } else {
                        maxHeap.add(minHeap.poll());
                    }

                } else {
                    minHeap.add(input[i]);
                }
            }


            int sum = 0;
            if (maxHeap.size() != 0) {
                sum += maxHeap.peek();
            }
            if (minHeap.size() != 0) {
                sum += minHeap.peek();
            }

            median = sum/2;

           // System.out.println(median);
        }
    }
}

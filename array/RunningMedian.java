package array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RunningMedian {

    public static void main(String[] args) {

        int a[]= {5,15,1,3,2,8,7,9,10,6,11,4};
        int median =0;

        PriorityQueue<Integer> leftHeap  = new PriorityQueue<>(Comparator.reverseOrder()); // max
        PriorityQueue<Integer> rightHeap  = new PriorityQueue<>(); // min

        for(int i=0;i<a.length;i++){
             median = getMedian(a[i],median,leftHeap,rightHeap);
            System.out.print(median+",");
        }
    }

    private static int getMedian(int element, int median, PriorityQueue<Integer> leftHeap, PriorityQueue<Integer> rightHeap) {

        double size = Math.signum(leftHeap.size() - rightHeap.size());

        if(size ==0){
            if(element < median){
                leftHeap.add(element);
                return leftHeap.peek();
            }
            else{
                rightHeap.add(element);
                return rightHeap.peek();
            }
        }
        else if(size ==1){
            if(element<median){
                rightHeap.add(leftHeap.poll());
                leftHeap.add(element);
            }
            else {
                rightHeap.add(element);
            }
            return (leftHeap.peek()+rightHeap.peek())/2;
        }
        else {
            // size =-1 , right is more
            if(element<median){
                leftHeap.add(element);
            }
            else{
                leftHeap.add(rightHeap.poll());
                rightHeap.add(element);
            }
            return (leftHeap.peek()+rightHeap.peek())/2;
        }
    }


}

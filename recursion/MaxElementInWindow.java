package recursion;

import java.util.Deque;
import java.util.LinkedList;

public class MaxElementInWindow {

    public static void main(String[] args) {
        int a [] = {9,7,2,4,6,9,8,1};
        // max 9,7,6,9,9,9
        int k=3;


        Deque<Integer> deque = new LinkedList<>();
        int i=0;
        for(i=0;i<a.length;i++){

            while(!deque.isEmpty() && deque.peekFirst()<a[i]){
                deque.removeFirst();
            }

            if(deque.isEmpty()  ||a[i]>deque.peekFirst() )
            deque.addFirst(a[i]);

            if(i%k==0){
                System.out.println(deque.peekFirst());
            }
        }

    }
}

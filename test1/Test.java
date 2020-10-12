package test1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Test {

    public static void main(String[] args) {
        int input [] = {170, 45, 75, 90, 802, 24, 2, 66};
        int k=3;

        PriorityQueue<Integer> pq = new PriorityQueue<>(k);

        /*for(int i: input){
            if(pq.size() <k){
                pq.add(i);
            }
            else{
                if(i > pq.peek()){
                    pq.remove();
                    pq.add(i);
                }
            }
        }

        while(!pq.isEmpty()){
            System.out.println(pq.remove()+",");
        }
*/

        procedure(input,0,input.length);
        Arrays.stream(input).forEach(e-> System.out.print(e+","));
    }

    private static void procedure(int[] input,int startIndex,int length) {
        System.out.println(startIndex +" , "+length);
        for(int i=startIndex;i<length/2;i++){
            heapify(input,i);
        }
    }

    public static void heapify(int [] input,int index){

        if(2*index+1 >=input.length || (2*index+2) >=input.length) return;


        if(input[index] > input[2*index+1] && input[index] >input[2*index+2]){
            System.out.println("Already in place");
        }
        else{
            if(input[2*index+1] >input[index] && input[2*index+1] >input[2*index+2]){
                int temp = input[2*index+1];
                input[2*index+1] = input[index];
                input[index] = temp;
            }else {
                int temp = input[2*index+2];
                input[2*index+2] = input[index];
                input[index] = temp;
            }

            procedure(input,0,2*index+2);
        }


    }


}

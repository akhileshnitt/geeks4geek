package recursion;

import java.util.Stack;

public class NGE {


    public static void main(String[] args) {
       // int a [] = {4, 5, 2, 25};

       // int a [] = {13, 7, 6, 12};

        int a [] = {4,3,2,1};

        Stack<Integer> stack = new Stack<>();
        stack.push(a[0]);

        for(int i=1;i<a.length;i++){

            if(a[i]< stack.peek()){
                stack.push(a[i]);
            }
            else{

                while(!stack.isEmpty() && stack.peek()<a[i]){
                    int temp = stack.pop();
                    System.out.println(temp +"->"+a[i]);
                }
                stack.push(a[i]);
            }
        }

        while(!stack.isEmpty()){
            System.out.println( stack.pop() +" ->"+" -1");
        }

    }
}

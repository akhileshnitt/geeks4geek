package mustodo.arrays.stack;

import java.util.Stack;

public class NGE {
    public static void main(String[] args) {
        int a [] = {1 ,3, 2, 4};
        //int a [] = {4, 3 ,2, 1};

        nextGreaterElement(a);
    }

    private static void nextGreaterElement(int[] a) {
        Stack<Integer> out = new Stack<>();

        out.push(-1);

        Stack<Integer> stack = new Stack<>();
      //  System.out.print(-1+",");
        stack.push(a[a.length-1]);


        for(int i=a.length-2;i>=0;i--){
            if(a[i] < stack.peek()){
                out.push(stack.peek());
              //  System.out.print(stack.peek()+",");
                stack.push(a[i]);
            }
            else{

                while(a[i]>stack.peek()){
                    stack.pop();
                    if(!stack.isEmpty())
                    out.push(stack.peek());
                    else
                        out.push(-1);

                    //System.out.print(stack.peek()+",");

                    stack.push(a[i]);
                }
            }
        }

        while (!out.isEmpty()){
            System.out.print(out.pop()+",");
        }
    }
}

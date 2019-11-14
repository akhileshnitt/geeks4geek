package stack;

import java.util.Stack;

public class NGE {
    public static void main(String[] args) {
        int a [] = {13, 7, 6, 12};
        int out[] = new int[a.length];

        Stack<Integer> stack = new Stack<Integer>();

        for(int i=a.length-1;i>=0;i--){
            if(stack.isEmpty()){
                stack.push(a[i]);
                out[a.length-1 -i] = -1;
            }
            else{
                if(a[i]<stack.peek()){
                    out[a.length-1-i] = stack.peek();
                    stack.push(a[i]);

                }
                else {
                    while(!stack.isEmpty() && a[i]>stack.peek()){
                        stack.pop();

                    }
                    if(!stack.isEmpty())
                    out[a.length-1-i] = stack.peek();
                    else
                        out[a.length-1-i] = -1;
                    stack.push(a[i]);
                }
            }

        }

        for(int j:out){
            System.out.println(j+" ,");
        }
    }
}

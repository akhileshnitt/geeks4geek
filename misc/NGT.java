package misc;

import java.util.Stack;

public class NGT {


    public static void main(String[] args) {
        int a[] = {17,6,7,13};

       // int a[] = {17,7,6,13};

        findNGE(a);
        System.out.println();
        int  b[] = {17,7,6,13};
        findNGE(b);

        System.out.println();
        int c[] = {4,5,2,25};
        findNGE(c);

        System.out.println();
        int d[] = {4,2,5,25};
        findNGE(d);

    }

    private static void findNGE(int[] a) {
        Stack<Integer> stack = new Stack<>();

        stack.push(-1);

        for(int i=a.length -1 ;i>=0;i--){

            if(stack.size()>1 && stack.peek()>a[i]) {
                System.out.println(a[i] + " -> " + stack.peek());
            }else if(stack.size() ==1 ){
                System.out.println(a[i] + " -> " + stack.peek());
            }else{
                while(stack.size() >1){
                    if(a[i]>stack.peek()){
                        stack.pop();
                    }
                    else{
                        break;
                    }
                }
                System.out.println(a[i] + " -> " + stack.peek());
            }
            stack.push(a[i]);
        }
    }
}

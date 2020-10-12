package misc;

import java.util.Stack;

public class StockSpan {

    public static void main(String[] args) {
        int a [] = { 10, 4, 5, 90, 120, 80 };

        //span1(a);

        span2(a);
    }

    private static void span2(int[] a) {

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        int span [] = new int[a.length];
        span[0] = 1;

        for(int i=1;i<a.length;i++){
            while (!stack.isEmpty() && a[stack.peek()] <= a[i]){
                stack.pop();
            }

            span[i] = (stack.empty()) ? (i + 1) : (i - stack.peek());
        }

        for (int p :span){
            System.out.print(p+",");
        }
    }

    private static void span1(int[] a) {
        int span [] = new int[a.length];

        for(int i=a.length-1;i>=0;i--){
            span[i] = fillSpan(a,i);
        }

        for (int i: span){
            System.out.print(i+",");
        }
    }

    private static int fillSpan(int[] a, int index) {
        int span = 1;
        for(int i=index-1;i>=0;i--){
            if(a[i]<a[index]){
                span++;
            }
            else break;
        }
        return span;
    }
}

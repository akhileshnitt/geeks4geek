package mustodo.arrays.stack;

import java.util.Stack;



public class MinElement {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();


       /* Push(stack,minStack,18);
        Push(stack,minStack,19);
        Push(stack,minStack,29);
        Push(stack,minStack,15);
        Push(stack,minStack,16);
        System.out.println(minElement(stack,minStack));
        Pop(stack,minStack);
        Pop(stack,minStack);
        System.out.println(minElement(stack,minStack));*/

        Push(stack,minStack,3);
        Push(stack,minStack,5);
        System.out.println(minElement(stack,minStack));
        Push(stack,minStack,2);
        Push(stack,minStack,1);
        System.out.println(minElement(stack,minStack));
        Pop(stack,minStack);
        System.out.println(minElement(stack,minStack));
        Pop(stack,minStack);
        Pop(stack,minStack);

        System.out.println(minElement(stack,minStack));
    }

    private static int minElement(Stack<Integer> stack, Stack<Integer> minStack) {
       return minStack.peek();
    }

    private static void Push(Stack<Integer> stack, Stack<Integer> minStack, int entry) {
       if(stack.isEmpty()){
           stack.push(entry);
           minStack.push(entry);
       }else{
           stack.push(entry);
           if(entry>minStack.peek()){
               minStack.push(minStack.peek());

           }else{
               minStack.push(entry);
           }
       }

    }

    private static void Pop(Stack<Integer> stack, Stack<Integer> minStack) {
         stack.pop();
         minStack.pop();
    }
}

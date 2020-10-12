package mustodo.arrays.stack;

import java.util.Stack;

public class MyQueue<E> implements IQueue<E>{

    private  Stack stack1 = null;
    private  Stack stack2 = null;

    public MyQueue() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    @Override
    public void add(E t) {
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        stack1.add(t);
    }

    @Override
    public E poll() {
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return  stack2.isEmpty()?null:(E)stack2.pop();
    }

    @Override
    public E peek() {
       if(!stack2.isEmpty()){
           return (E)stack2.peek();
       }
       return (E)stack1.peek();
    }
}

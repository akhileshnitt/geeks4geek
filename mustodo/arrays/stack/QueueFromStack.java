package mustodo.arrays.stack;

public class QueueFromStack {
    public static void main(String[] args) {

        MyQueue<Integer> queue = new MyQueue<>();
       /* queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());*/


       /* queue.add(1);
        queue.add(2);
        System.out.println(queue.poll());
        queue.add(3);

        System.out.println(queue.poll());*/

        MyQueue<String> stringQueue = new MyQueue<>();
        stringQueue.add("akh");
        stringQueue.add("ansh");
        //System.out.println(stringQueue.peek());
        System.out.println(stringQueue.poll());
        System.out.println(stringQueue.poll());
        System.out.println(stringQueue.poll());


    }
}

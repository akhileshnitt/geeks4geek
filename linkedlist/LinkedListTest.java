package linkedlist;

public class LinkedListTest {
    public static void main(String[] args) {

        Node head = null;
        for(int i=1;i<=2;i++){
            head = LinkListUtil.addNode(i);
        }

        LinkListUtil.traverseList(head);

     /*   LinkListUtil.addNodeAfter(3,10);
        System.out.println("after inserting");
        LinkListUtil.traverseList(head);
        System.out.println();
*/
        System.out.println("delete from list ");
        //Node h = LinkListUtil.delete(10);
        //LinkListUtil.traverseList(h);

        System.out.println("Reverse in pair");

        Node h2 = LinkListUtil.reverseInPair(head);
        LinkListUtil.reverseInPair(h2);


    }
}

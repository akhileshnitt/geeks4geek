package lru;

import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList  linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.remove();
        System.out.println(linkedList.getFirst());
    }
}

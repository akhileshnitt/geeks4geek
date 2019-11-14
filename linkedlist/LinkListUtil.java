package linkedlist;

public class LinkListUtil {

    static Node head;

    public static Node addNode(int data){

        if(head == null){
            Node temp = new Node(data);
            head = temp;

        }
        else {
            // add node at last
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            Node newTemp = new Node(data);
            temp.next = newTemp;

        }
        return head;
    }

    public static void traverseList(Node head) {

        Node temp = head;
        while(temp != null){
            System.out.print(temp.data +"->");
            temp = temp.next;
        }
        System.out.println();
    }


    public static void addNodeAfter(int source, int data){

        Node temp = head;

        while(temp != null){
            if(temp.data == source){
                break;
            }
            temp = temp.next;
        }

        Node newTemp = new Node(data);
        newTemp.next = temp.next;
        temp.next = newTemp;


    }

    public  static Node  delete(int data){


        if(head.data == data){
            return  head.next;
        }
        else {
            Node temp = head;
            Node previous = null;
            while (temp != null) {
                if (temp.data == data) {
                    break;
                }
                previous = temp;
                temp = temp.next;
            }

            previous.next = temp.next;
            return head;
        }

    }

    public static Node reverseInPair(Node head) {
        Node temp = head;

        Node current = temp;
        Node next = temp.next;

        while(current != null && next != null){

            Node temp1 = current;
            current.next = current.next.next;
            next.next = current;

        }

        return next;

    }
}

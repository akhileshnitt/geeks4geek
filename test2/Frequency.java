package test2;

public class Frequency {

    public static void main(String[] args) {
        Node root = new Node(1);

        Node node2 = new Node(2);
        Node node3= new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);


        root.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        printList(root);

        int n=2;

        System.out.println();

        printNthFromLast(root,n);


    }

    private static void printNthFromLast(Node root, int n) {

        Node temp = root;

        for(int i=0;i<n;i++){
            temp = temp.next;
        }

        while(temp != null){
            temp = temp.next;
            root = root.next;
        }
        System.out.println(root.data);
    }

    private static void printList(Node root) {
        while(root != null){
            System.out.print(root.data+",");
            root = root.next;
        }
    }

}


class Node{
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;

    }
}
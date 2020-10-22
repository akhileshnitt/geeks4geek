import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test2 {

    public static void main(String[] args) {

        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        root.left = node2 ;
        root.right = node3;





        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node2.left = node4;
        node2.right = node5;

        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node3.left = node6;
        node3.right = node7;

       // inOrder(root);

        levelOrderTraversal(root);



    }

    private static void levelOrderTraversal(Node root) {

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        Stack<Node> st = new Stack<>();

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Node temp = queue.poll();
                st.push(temp);
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
            }
        }

        while (!st.isEmpty()){
            System.out.print(st.pop().data+",");
        }
    }

    private static void inOrder(Node root) {

        if(root != null){
            inOrder(root.left);
            System.out.print(root.data+",");
            inOrder(root.right);
        }
    }
}

class Node{
    int data;
    Node left ;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}

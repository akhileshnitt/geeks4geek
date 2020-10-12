package mustodo.arrays.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftView {

    static  int max_level =0;
    public static void main(String[] args) {

        Node root = new Node(4);
        Node node5 = new Node(5);
        Node node2 = new Node(2);
        root.left = node5;
        root.right = node2;

        Node node3 = new Node(3);
        Node node1 = new Node(1);

        node2.left = node3;
        node2.right = node1;

        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node3.left = node6;
        node3.right = node7;
        
        printLeftViewRec(root,1);


     /*   Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        root.left = node2;
        root.right = node3;

        Node node4 = new Node(4);
        node2.right = node4;

        Node node5 = new Node(5);
        node4.right = node5;

        Node node6 = new Node(6);
        node5.right = node6;
*/
       // printLeftView(root);

    }

    private static void printLeftViewRec(Node root,int level) {

        if(root != null){
            if(max_level <level){
                System.out.print(root.data+",");
                max_level = level;
            }
            printLeftViewRec(root.left,level+1);
            printLeftViewRec(root.right,level+1);
        }
    }

    private static void printLeftView(Node root) {
        Queue<Node> queue =  new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int queueSize  = queue.size();

           boolean  once = false;
            for(int i=0;i<queueSize;i++){
                Node node = queue.poll();
                if(!once) {
                    System.out.print(node.data + ",");
                    once = true;
                }
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }


        }
    }
}


class Node {
    Node left;
    Node right;
    int data;

    public Node(int data) {
        this.data = data;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
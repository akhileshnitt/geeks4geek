package mustodo.arrays.tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckBST {

    public static void main(String[] args) {

        Node root = new Node(3);
        Node node5 = new Node(5);
        Node node2 = new Node(2);

        root.left = node2;
        root.right = node5;


        Node node1 = new Node(1);
        Node node4 = new Node(4);

        node2.left  = node1;
        node2.right = node4;


      /*  Node root = new Node(4);
        Node node2 = new Node(2);
        Node node5 = new Node(5);

        root.left = node2;
        root.right = node5;


        Node node1 = new Node(1);
        Node node3 = new Node(3);


        node2.left  = node1;
        node2.right = node3;*/

        boolean isBST = isBST(root);
        System.out.println(isBST);





       /* int a []= {1,2,8,4,5,6};

        boolean isSorted = isSorted(a);
        System.out.println(isSorted);*/

    }

    private static boolean isBST(Node root) {
        if(root == null) return true;

        if(maxValue(root.left) >root.data||minValue(root.right) <root.data){
            return false;
        }
        return isBST(root.left) && isBST(root.right);

    }



    private static int minValue(Node root) {
        if(root == null) return Integer.MAX_VALUE;
        if(root.left == null) return root.data;
        return minValue(root.left);
    }

    private static int maxValue(Node root) {
        if(root == null) return Integer.MIN_VALUE;
        if(root.right == null) return root.data;
        return maxValue(root.right);
    }

    private static boolean isSorted(int[] a) {
        for(int i=0;i<a.length-1;i++){
            if(a[i+1] <a[i]) return false;
        }
        return true;
    }
}


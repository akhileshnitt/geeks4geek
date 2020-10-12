package tree;

import java.util.ArrayList;
import java.util.List;

public class KRayTreePreOrder {

    static int arrIndex=0;

    public static void main(String[] args) {
        int pre [] = {1,2,5,6,7,3,8,9,10,4};
        int k=3;
        Node root = null;

        root = constructTree(pre,0,k,root,0);
        System.out.println(root);

        postOrderTraversal(root);


    }

    private static void postOrderTraversal(Node root) {


        if(root != null){
            for(Node temp :root.children) {
                postOrderTraversal(temp);
                if(temp != null)
                System.out.print(temp.data+",");

            }

        }

    }

    private static Node constructTree(int[] pre, int index, int k, Node temp,int level) {

        if(arrIndex >= pre.length) return null;

        temp = new Node(pre[arrIndex]);
        arrIndex = arrIndex+1;

        level = level+1;


        if(level >= k){
            return temp;
        }


        for(int i=0;i<k;i++){
                temp.children.add(i,constructTree(pre, arrIndex, k, null,level));
        }

        return temp;
    }

    static class Node{
        int data;
        List<Node> children;

        public Node(int data) {
            this.data = data;
            this.children = new ArrayList<>();
        }
    }
}

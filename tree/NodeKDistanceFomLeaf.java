package tree;

import java.util.HashSet;
import java.util.Set;

public class NodeKDistanceFomLeaf {



    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);


        int k=4;
        int pathLength=0;
        int []path = new int[100];
        Set<Integer> set = new HashSet<>();
        printNodeKDistanceFromLeaf(root,path,pathLength,k,set);
    }

    private static void printNodeKDistanceFromLeaf(Node root, int[] path, int pathLength, int k,Set set) {

        if(root == null) return;

        path[pathLength] = root.data;
        pathLength = pathLength +1;

        if(NodeUtil.isLeaf(root) && pathLength- k -1>=0 ){
            // print ancesstor node at distance k
            if(!set.contains(path[pathLength- k -1])) {
                set.add(path[pathLength - k - 1]);

                System.out.println(path[pathLength - k - 1]);
            }
            return;
        }

        printNodeKDistanceFromLeaf(root.left,path,pathLength,k,set);
        printNodeKDistanceFromLeaf(root.right,path,pathLength,k,set);
    }
}

package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NextRightNode {

    public static final int MARKER = -1;

    public static void main(String[] args) {
        Node root = new Node(10);
        Node node2 = new Node(2);
        Node node6 = new Node(6);
        Node node8 = new Node(8);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        root.left = node2;
        root.right = node6;

        node2.left= node8;
        node2.right = node4;

        node6.right = node5;

       // NodeUtil.inOrder(root);

      //  printNextRightNode(root);

        Node [] path = new Node[100];
     //   printRootToLeafPath(root,path,0);

        printNodeAtDistanceK(root,1);

    }

    private static void printNodeAtDistanceK(Node root, int k) {
        if(root == null) return;

        if(k==0){
            System.out.print(root.data+",");
        }
        printNodeAtDistanceK(root.left,k-1);
        printNodeAtDistanceK(root.right,k-1);
    }

    private static void printNextRightNode(Node root) {
        List<Integer> results = levelOrderTraversal(root);

        int noToRight = 4;

        for(int i=0;i<results.size();i++){
            if(results.get(i) == noToRight && i<results.size()){
                System.out.println(results.get(i+1));
                break;
            }
        }

    }

    private static void printRootToLeafPath(Node root,Node [] path, int pathLength) {
        if(root == null) return;

        if(NodeUtil.isLeaf(root)){
            path[pathLength++] = root;
            printPath(path,pathLength);

            return;
        }

        path[pathLength++] = root;
        printRootToLeafPath(root.left, path,pathLength);
        printRootToLeafPath(root.right,path,pathLength);

    }

    private static void printPath(Node[] path, int pathLength) {

        System.out.println();
        for(int i=0;i<pathLength;i++){
            System.out.print(path[i].data+"->");
        }
    }

    private static List<Integer> levelOrderTraversal(Node root) {

        List<Integer> resultList = new ArrayList<Integer>();
       // resultList.add(root.data);

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){

            int size = queue.size();
            for(int i=0;i<size;i++){
                Node temp = queue.poll();
                resultList.add(temp.data);
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
            resultList.add(MARKER);
        }
        return resultList;

    }
}

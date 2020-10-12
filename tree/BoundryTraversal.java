package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static tree.NodeUtil.isLeaf;

public class BoundryTraversal {

    public static void main(String[] args) {
        Node root = new Node(20);
        Node node8 = new Node(8);
        Node node22 = new Node(22);

        root.left = node8;
        root.right = node22;

        Node node4 = new Node(4);
        Node node12 = new Node(12);
        node8.left = node4;
        node8.right = node12;

        Node node10 = new Node(10);
        Node node14 = new Node(14);
        node12.left = node10;
        node12.right = node14;


        Node node25 = new Node(25);
        node22.right = node25;

        //NodeUtil.inOrder(root);

        printBoundry(root);




    }

    private static void printBoundry(Node root) {


        List<Node> list1 = leftBoundary(root);
        List<Node> list2 = boottomTraversal(root);

        List<Node> list3 = rightBoundry(root);

        //20 8 4 10 14 25 22

        List<Node> list = new ArrayList<>();
        list.addAll(list1);
        for(Node node : list2) {
            if(!list.contains(node))
            list.add(node);
        }

        for(Node node : list3) {
            if(!list.contains(node))
                list.add(node);
        }

        list.forEach(e-> System.out.print(e.data+","));


    }

    private static List<Node> boottomTraversal(Node root) {
        List<Node> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            boolean once = false;
            for(int i=0;i<size;i++){
                Node temp = queue.poll();
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);

                if(isLeaf(temp)){
                    list.add(temp);
                }

            }
        }
        return list;
    }

    private static int depth(Node root) {
        if(root == null){
            return 0;
        }
        return 1+Math.max(depth(root.left),depth(root.right));
    }

    private static List<Node> rightBoundry(Node root) {

        List<Node> list = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            boolean once = false;
            for(int i=0;i<size;i++){
                Node temp = queue.poll();
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);

                if(i==size-1) {
                    list.add(temp);
                }
                once = true;

            }
        }
        list.remove(0);
        List<Node> tempList = new ArrayList<>();
        for(int i=list.size()-1;i>=0;i--){

            tempList.add(list.get(i));
        }


        return tempList;
    }

    private static List<Node> leftBoundary(Node root) {

        List<Node> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
             boolean once = false;
            for(int i=0;i<size;i++){
                Node temp = queue.poll();
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);

                if(!once) {
                    list.add(temp);
                }
                once = true;

            }
        }
        return list;
    }
}

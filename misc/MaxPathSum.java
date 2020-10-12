package misc;

import tree.Node;

public class MaxPathSum {

    public static void main(String[] args) {
        Node root  = new Node(-8);
        Node node2  = new Node(2);
        Node node6  = new Node(6);

        root.setLeft(node2);
        root.setRight(node6);

        int maxPathSum = maxPathSum(root);
        System.out.println(maxPathSum);
    }

    private static int maxPathSum(Node root) {
        if(root == null)
            return 0;

        if(root.getLeft() == null && root.getRight() == null){
            return root.getData();
        }
        int leftSum = maxPathSum(root.getLeft());
        int rightSum = maxPathSum(root.getRight());

        int rootSum = leftSum+rightSum+root.getData();

        return Math.max(Math.max(leftSum,rightSum),rootSum);
    }

}

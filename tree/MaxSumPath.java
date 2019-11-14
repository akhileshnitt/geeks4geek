package tree;

public class MaxSumPath {

    static int maxValue = Integer.MIN_VALUE;

    public static void main(String[] args) {

        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(10);
        root.left.left = new Node(20);
        root.left.right = new Node(1);
        root.right.right = new Node(-25);
        root.right.right.left = new Node(3);
        root.right.right.right = new Node(4);


     //   inorderTraversal(root);

        int maxPathSum = maxPathSum(root);

        System.out.println(maxValue);

    }

    private static int maxPathSum(Node root) {

        if(root == null) {
            return 0;
        }

       /* if(isLeaf(root)){
            return root.data;
        }*/

        int lSum = maxPathSum(root.left);
        int rSum = maxPathSum(root.right);
        int simple =  Math.max(Math.max(root.data,root.data+lSum),root.data+rSum);
        maxValue = Math.max(maxValue,simple+root.data);


        return simple;

    }

    private static void inorderTraversal(Node root) {
        if(root != null){
            inorderTraversal(root.left);
            System.out.print(root.data+",");
            inorderTraversal(root.right);
        }
    }
}

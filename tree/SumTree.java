package tree;

public class SumTree {
    public static void main(String[] args) {
        Node root26 = new Node(26);
        Node node10 = new Node(10);
        Node node3 = new Node(3);

        Node node4 = new Node(4);
        Node node6 = new Node(6);

        Node node33 = new Node(3);

        root26.left = node10;
        root26.right = node3;

        node10.left = node4;
        node10.right = node6;

        node3.left = node33;

        //   NodeUtil.inOrder(root26);

        boolean isSumTree = isSumTree(root26);
        System.out.println(isSumTree);


    }

    private static boolean isSumTree(Node root) {

        if (root == null) return true;

        if (NodeUtil.isLeaf(root)) {
            return true;
        } else {
            int leftSum = sum(root.left);
            int rightSum = sum(root.right);
            return ((root.data == leftSum + rightSum) && isSumTree(root.left) && isSumTree(root.right));
        }
    }

    private static int sum(Node root) {

        if (root == null) {
            return 0;
        }
        return root.data + sum(root.left) + sum(root.right);
    }
}

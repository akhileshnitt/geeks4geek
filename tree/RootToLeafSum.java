package tree;

public class RootToLeafSum {

    public static void main(String[] args) {
        Node root = new Node(6);
        Node node3 = new Node(3);
        Node node5 = new Node(5);

        Node node2 = new Node(2);
        Node node55 = new Node(5);
        Node node4 = new Node(4);

        node3.left = node2;
        node3.right = node55;

        node5.right = node4;

        Node node7 = new Node(7);
        Node node44 = new Node(4);

        node55.left = node7;
        node55.right = node44;



        root.left = node3;
        root.right = node5;

        int sum = rootToLeafSum(root,0);
        System.out.println(sum);
    }

    private static int rootToLeafSum(Node root, int value) {

        if(root == null){
            return 0;
        }
        if(NodeUtil.isLeaf(root)){
            return value *10 +root.data;
        }

        value  = value *10 +root.data;
        int leftSum = rootToLeafSum(root.left,value);
        int rightSum = rootToLeafSum(root.right, value);
        return leftSum+rightSum;

    }
}

package tree;

public class DoubleTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        Node node4 = new Node(4);
        Node node5 = new Node(5);

        root.left = node2;
        root.right = node3;

        node2.left = node4;
        node2.right = node5;

        NodeUtil.inOrder(root);

        System.out.println();
        Node doubleRoot = doubleTree(root);
        NodeUtil.inOrder(doubleRoot);

    }

    private static Node doubleTree(Node root) {
        if(root == null){
            return null;
        }

        Node left = doubleTree(root.left);
        Node right = doubleTree(root.right);

        Node nextNode = null;

        if(root.left != null) {
            nextNode = root.left;
        }

        Node tempNode = new Node(root.data);
        root.left = tempNode;
        tempNode.left = nextNode;

        return root;
    }
}

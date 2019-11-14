package tree;

public class MaxHeight {
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

        int maxHeight  = maxHeight(root);
        System.out.println("maxHeight: "+maxHeight);

        int size= size(root);

        System.out.println("size :"+size);
    }

    private static int size(Node root) {

        if(root == null) return 0;
        return 1+size(root.left)+size(root.right);
    }

    private static int maxHeight(Node root) {

        if(root == null){
            return  0;
        }
        return 1+Math.max(maxHeight(root.left),maxHeight(root.right));
    }
}

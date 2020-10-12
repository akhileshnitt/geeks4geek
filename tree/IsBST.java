package tree;

public class IsBST {

    public static void main(String[] args) {

        Node root = new Node(3);

        Node node2 = new Node(2);
        Node node5 = new Node(5);

        root.left = node2;
        root.right = node5;

        Node node1 = new Node(1);
        Node node4 = new Node(4);

        node2.left = node1;
        node2.right = node4;


       /* Node root = new Node(4);

        Node node2 = new Node(2);
        Node node5 = new Node(5);

        root.left = node2;
        root.right = node5;

        Node node1 = new Node(1);
        Node node3 = new Node(3);

        node2.left = node1;
        node2.right = node3;*/

        System.out.println(isBST1(root,null,null));
    }

    private static boolean isBST(Node root) {

        if(root == null) return false;

        if(root.left == null && root.right == null) return true;

        int maxL = max(root.left);
        int marR = max(root.right);
        //System.out.println(maxL +" "+marR);

        return  root.data >maxL && root.data<marR && isBST(root.left) && isBST(root.right);
    }

    private static int max(Node root) {
        if(root == null) return 0;
        return Math.max( (Math.max(max(root.left),max(root.right))),root.data);
    }


    static boolean isBST1(Node root, Node l, Node r)
    {
        // Base condition
        if (root == null)
            return true;

        // if left node exist then check it has
        // correct data or not i.e. left node's data
        // should be less than root's data
        if (l != null && root.data <= l.data)
            return false;

        // if right node exist then check it has
        // correct data or not i.e. right node's data
        // should be greater than root's data
        if (r != null && root.data >= r.data)
            return false;

        // check recursively for every node.
        return isBST1(root.left, l, root) &&
                isBST1(root.right, root, r);
    }
}

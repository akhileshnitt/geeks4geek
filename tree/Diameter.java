package tree;

public class Diameter {

    public static void main(String[] args) {

        Node n1 = new Node(1);

        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.left = n2;
        n1.right = n3;


        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n2.left = n4 ; n2.right = n5;

        Node n6 = new Node(6);
        Node n7 = new Node(7);
        n4.left = n6; n4.right = n7;

        Node n8 = new Node(8);
        n7.left = n8;

         Node n9 = new Node(9);
        n8.right = n9;

        Node n10 = new Node(10);
        n5.right = n10;

        Node n11 = new Node(11);
        Node n12 = new Node(12);
        n10.left = n11; n10.right = n12;

        Node n13 = new Node(13);
        n12.left = n13;


       //NodeUtil.inOrder(n1);



       int diameter = diameter(n1);
        System.out.println("diameter :"+diameter);

    }

    private static int diameter(Node root) {

        if(root == null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        int ld = diameter(root.left);
        int rd = diameter(root.right);

        return  Math.max(Math.max(ld,rd),lh+rh+1);

    }

    private static int height(Node root) {
        if(root == null) return 0;
        return 1+ Math.max(height(root.left),height(root.right));
    }


}

package tree;

public class NodeUtil {

    public static void inOrder(Node root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.data+",");
            inOrder(root.right);
        }
    }

    public static boolean isLeaf(Node root) {
        if(root == null) return false;
        if(root.left == null && root.right == null) return true;
        return false;
    }
}

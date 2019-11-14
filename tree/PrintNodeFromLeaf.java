package tree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrintNodeFromLeaf {
    static Set<Node> nodes = new HashSet<Node>();
    static Set<Node> ancessNode = new HashSet<Node>();

    public static void main(String[] args) {

       /* Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

*/

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);

        int k = 3;
        int targetNode = 4;

        Node path[] = new Node[20];
        Arrays.fill(path, null);
        int pathLength = 0;

    //    findPath(root, targetNode, path, pathLength, false, k);


        k=2;
        findPathFromLeaf(root, targetNode, path, pathLength, false, k);
    }



    private static void findPathFromLeaf(Node root,  int targetNode, Node[] path, int pathLength, boolean found, int k) {

        if (root == null) {
            return ;
        }
        if (NodeUtil.isLeaf(root)) {

            ancessNode.add(root);
            printNode(root, k);
            for (int i = 0; i < pathLength; i++) {
                ancessNode.add(path[i]);
            }

            for (int i = 0; i < pathLength; i++) {
                printNodeWithOut(path[pathLength - 1 - i], k - 1 - i);
            }
            return ;
        }
        path[pathLength++] = root;
        findPathFromLeaf(root.left, targetNode, path, pathLength, found, k);
        findPathFromLeaf(root.right, targetNode, path, pathLength, found, k);


    }



    private static boolean findPath(Node root, int targetNode, Node[] path, int pathLength, boolean found, int k) {

        if (root == null) {
            return false;
        }
        if (root.data == targetNode) {

            ancessNode.add(root);
            printNode(root, k);
            for (int i = 0; i < pathLength; i++) {
                ancessNode.add(path[i]);
            }

            for (int i = 0; i < pathLength; i++) {
                printNodeWithOut(path[pathLength - 1 - i], k - 1 - i);
            }
            // nodes.stream().forEach(e-> System.out.println(e.data));
            found = true;
            return found;
        }
        path[pathLength++] = root;
        boolean isFound = findPath(root.left, targetNode, path, pathLength, found, k);
        if (isFound) {
            return true;
        } else {
            return findPath(root.right, targetNode, path, pathLength, found, k);
        }

    }

    private static void printNodeWithOut(Node node, int k) {
        if (node == null) return;

        if (k == 0) {
            System.out.println(node.data);
            //    nodes.add(root);
            return;
        }
        if (!ancessNode.contains(node.left)) {
            printNodeWithOut(node.left, k - 1);
        }
        if (!ancessNode.contains(node.right)) {
            printNodeWithOut(node.right, k - 1);

        }
    }

    private static void printNode(Node root, int k) {

        if (root == null) return;

        if (k == 0) {
            System.out.println(root.data);
            nodes.add(root);
            return;
        }
        printNode(root.left, k - 1);
        printNode(root.right, k - 1);
    }
}

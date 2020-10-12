package tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopView {

    public static void main(String[] args) {

        /**
         *
         *        1
         *     /     \
         *    2       3
         *   /  \    / \
         *  4    5  6   7
         *
         */
        Node root = new Node(1);

        Node node2 = new Node(2);
        Node node3 = new Node(3);

        root.left = node2;
        root.right = node3;

        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node2.left = node4;
        node2.right = node5;

        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node3.left = node6;
        node3.right = node7;

      //  NodeUtil.inOrder(root);

        printTopView1(root);


        System.out.println();


        /**
         *
         1
         /     \
         2       3
         \
         4
         \
         5
         \
         6
         */

       /* Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        root.left = node2;
        root.right = node3;

        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node2.right = node4;
        node4.right = node5;

        Node node6 = new Node(6);
        node5.right = node6;

        printTopView1(root);
*/

    }

    private static void printTopView1(Node root) {
        Map<Integer, Integer> map = new TreeMap<>();

        traverseLevel(root, map);

    }

    private static void traverseLevel(Node root, Map<Integer, Integer> map) {

        Queue<NodeLevel> queue = new LinkedList<>();
        queue.add(new NodeLevel(root,0));

        while (!queue.isEmpty()) {
            NodeLevel node = queue.poll();

            if (map.get(node.level) == null) {
                map.put(node.level, node.node.data);
            }
            if(node.node.left != null){
                queue.add(new NodeLevel(node.node.left,node.level-1));
            }
            if(node.node.right != null){
                queue.add(new NodeLevel(node.node.right,node.level+1));
            }
        }

        map.entrySet().forEach(e->{
            System.out.print(e.getValue()+",");
        });
    }

    static class NodeLevel{
        Node node;
        int level;

        public NodeLevel(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

}

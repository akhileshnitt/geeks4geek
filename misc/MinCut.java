package misc;

import tree.Node;

public class MinCut {

    static int [] sum = new int[6];
    static int min_diff = Integer.MAX_VALUE;

    public static void main(String[] args) {
        // data, label
      /*  Node root = new Node(1,0);

        Node node2 = new Node(2,1);
        Node node3 = new Node(3,2);

        root.setLeft(node2);
        root.setRight(node3);

        Node node6 = new Node(6,5);
        node2.setLeft(node6);

        Node node4 = new Node(4,3);
        Node node5 = new Node(5,4);
        node3.setLeft(node4);
        node3.setRight(node5);
*/

        Node root = new Node(100,0);

        Node node200 = new Node(200,1);
        root.setRight(node200);

        Node node1001 = new Node(100,2);

        Node node2002 = new Node(100,3);
        node200.setLeft(node1001);
        node200.setRight(node2002);

        node1001.setLeft(new Node(500,4));

        node1001.setRight(new Node(600,5));

        dfs1(root,sum,totalSum(root));


        System.out.println(min_diff);



    }

    private static int totalSum(Node root) {
        if(root == null) return 0;
        return totalSum(root.getLeft())+totalSum(root.getRight())+root.getData();
    }

    private static void dfs(Node root, int[] sum) {

        if(root != null) {
            if (root.getLeft() != null) {
                dfs(root.getLeft(), sum);
            }
            if (root.getRight() != null) {
                dfs(root.getRight(), sum);
            }
            if(root.getLeft() == null && root.getRight() == null){
                sum[root.getLabel()] = root.getData();
            }
            else {
                if(root.getLeft() != null){
                    sum[root.getLabel()] += sum[root.getLeft().getLabel()];
                }

                if(root.getRight() != null){
                    sum[root.getLabel()] += sum[root.getRight().getLabel()];
                }

                sum[root.getLabel()] +=   +root.getData();
            }
        }
    }



    private static int  dfs1(Node root, int[] sum, int totalSum) {

        if(root == null) return 0;

        int leftSum = dfs1(root.getLeft(), sum, totalSum);
        int rightSum = dfs1(root.getRight(), sum, totalSum);

        sum[root.getLabel()] = leftSum+rightSum+root.getData();

        int subtree1 = totalSum - sum[root.getLabel()];
        int subtree2 = sum[root.getLabel()];

        int diff = Math.abs(subtree1-subtree2);
        if(diff <min_diff){
           min_diff = diff;
        }



        return leftSum+rightSum+root.getData();
    }
}

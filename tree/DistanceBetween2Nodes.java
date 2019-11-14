package tree;

public class DistanceBetween2Nodes {


    public static void main(String[] args) {
        // Let us create binary tree given in
        // the above example
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);



      //  System.out.println("Dist(4, 5) = "+distanceBetween(root, 4, 5));
       // System.out.println("Dist(4, 6) = "+distanceBetween(root, 4, 6));
        System.out.println("Dist(3, 4) = "+distanceBetween(root, 3, 4));
       // System.out.println("Dist(2, 4) = "+distanceBetween(root, 2, 4));
     //   System.out.println("Dist(8, 5) = " +distanceBetween(root, 8, 5));
    }

    private static int distanceBetween(Node root, int node1, int node2) {


        int pathLength1 = 0;
        int[] path1 = new int[100];
        findPath(root, node1, path1, pathLength1, false);
        int noOfNodesPath1 = findNumber(path1);

        int pathLength2 = 0;
        int[] path2 = new int[100];
        findPath(root, node2, path2, pathLength2, false);
        int noOfNodesPath2 = findNumber(path2);


        int lcaIndex = findLCAIndex(path1, pathLength1, path2, pathLength2);




        return noOfNodesPath1 +noOfNodesPath2 -2*lcaIndex;
    }

    private static int findNumber(int[] path1) {
        for(int i=0;i<path1.length;i++){
            if(path1[i] ==0){
                return i;
            }
        }
        return -1;
    }

    private static int findLCAIndex(int[] path1, int pathLength1, int[] path2, int pathLength2) {
        int i = 0, j = 0;
        while (i < path1.length && j < path2.length) {
            if (path1[i] == path2[j]) {
                i++;
                j++;
            } else {
                return i;
            }
        }
        return 0;
    }


    private static boolean findPath(Node root, int data, int[] path1, int pathLength1, boolean found) {


        if (root == null)
            return false;
        if (root.data == data) {
            path1[pathLength1++] = root.data;
            return true;
        }

        path1[pathLength1++] = root.data;
        boolean isFound = findPath(root.left, data, path1, pathLength1, found);
        if (isFound) {
            return true;
        } else {
            return findPath(root.right, data, path1, pathLength1, found);
        }


    }


}

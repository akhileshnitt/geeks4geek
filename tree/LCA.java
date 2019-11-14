package tree;

import java.util.ArrayList;
import java.util.List;

public class LCA {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int n1=5,n2=6;
       // int lca = findLCA(root, n1, n2);

        System.out.println(findLCA(root, 4, 5));
        System.out.println(findLCA(root, 4, 6));
        System.out.println(  findLCA(root, 3, 4));
        System.out.println(findLCA(root, 2, 4));

    }

    private static int findLCA(Node root, int n1, int n2) {

        // find root to n1 path
        List<Integer> path1 = new ArrayList<>();
        findPath(root,n1,path1);
        // find root to n2 path
        List<Integer> path2 = new ArrayList<>();
        findPath(root,n2,path2);
        // find Lca by comparing array
        int i=0,j=0;
        while(i<path1.size() && j<path2.size()){
            if(path1.get(i) != path2.get(i)){
               // System.out.println("LCA ::"+path1.get(i-1));
                return path1.get(i-1);
            }
            i++;j++;
        }
        return path1.get(path1.size()-1);
    }

    private static boolean findPath(Node root, int n, List<Integer> path) {
        if(root == null) {
            return false;
        }
        path.add(root.data);

        if(root.data == n){
            return true;
        }

        if(findPath(root.left,n,path)) {
            return true;
        }
        if(findPath(root.right,n,path)){
            return true;
        }

       /* if(root.left != null && findPath(root.left,n,path)) {
            return true;
        }
        if(root.right != null && findPath(root.right,n,path)){
            return true;
        }*/
        path.remove(path.size() -1);
        return false;


    }
}

package tree;

import java.util.ArrayList;
import java.util.List;

public class CorrectBst {

    public static void main(String[] args) {
        Node root = new Node(10);

        Node node5 = new Node(5);
        Node node2 = new Node(2);

        Node node8 = new Node(8);
        Node node20 = new Node(20);

        root.right = node20;
        root.left = node8;
        node8.left = node2;
        node8.right = node5;

      //  NodeUtil.inOrder(root);

        List<Integer> nodes = new ArrayList<>();
        NodeUtil.inOrderResult(root,nodes);

        System.out.println(nodes);



        System.out.println();
        int n1 = findBadNodsFromLeft(nodes);
        int n2 = findBadNodsFromRight(nodes);
        correctBst(root,n1,n2);
        NodeUtil.inOrder(root);
        
    }

    private static void correctBst(Node root, int n1, int n2) {

          Node noden1 = findNode(root,n1);
          Node noden2 = findNode(root,n2);

          int temp = noden2.data;
          noden2.data = noden1.data;
          noden1.data = temp;
     //   System.out.println(noden1);

    }

    private static Node findNode(Node root, int n1) {

        if(root == null){
            return null;
        }
        if(root.data == n1){
            return root;
        }
        Node temp = findNode(root.left,n1);
        if(temp == null){
            temp = findNode(root.right,n1);
        }

        return temp;
    }

    private static int findBadNodsFromLeft(List<Integer> a) {

        for(int i=1;i<a.size();i++){
            if(a.get(i)<a.get(i-1)){
                System.out.println("bad :"+a.get(i-1));
                return a.get(i-1);

            }
        }
        return -1;
    }

    private static int  findBadNodsFromRight(List<Integer> a) {

        for(int i=a.size()-1;i>=1;i--){
           if(a.get(i)<a.get(i-1)){
               System.out.println("bad :"+a.get(i));
               return a.get(i);
           }
        }
        return -1;
    }
}

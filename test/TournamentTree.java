//package test;
//
//import java.util.ArrayList;
//import java.util.Queue;
//
//public class TournamentTree {
//    public static void main(String[] args) {
//        Node root = new Node(100);
//        Node node100 = new Node(100);
//        Node node90 = new Node(90);
//
//        root.left = node100;
//        root.right = node90;
//
//        Node node1001 = new Node(100);
//        Node node95 = new Node(95);
//
//
//        int secondLargetr= larget(root);
//
//
//
//    }
//
//    private static int larget(Node root) {
//
//       Queue<Node > queue = new ArrayList<>();
//       queue.add(root);
//
//       while(!queue.isEmpty()){
//           int size = queue.size();
//           for(int i=0;i<size;i++){
//             Node temp = queue.remove();
//
//             Node  left =null,right =null;
//
//               if(temp.left != null){
//                   left = temp.left;
//               }
//               if(temp.right != null){
//                   right = temp.right;
//               }
//
//               if(left != null && right != null){
//                   if(left.data >right.data){
//                       queue.add(left);
//                   }
//                   else{
//                       queue.add(right);
//                   }
//               }
//
//           }
//       }
//
//
//    }
//
//
//}

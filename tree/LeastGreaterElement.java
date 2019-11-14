package tree;

import java.util.Arrays;

public class LeastGreaterElement {

    public static void main(String[] args) {
        int a[] = {8, 58, 71, 18, 31, 32, 63, 92,43, 3, 91, 93, 25, 80, 28};

                // 18, 63, 80, 25, 32, 43, 80, 93, 80, 25, 93, -1, 28, -1, -1
                // 18 ,63 ,80 ,25 ,32 ,43 ,80 ,93 ,80 ,25 ,93 ,-1, 28 ,-1, -1,

        findNavive(a);

        System.out.println();

        Node root = new Node(a[a.length-1]);
        int succA[] = new int [a.length];
        for(int i=a.length-1;i>=0;i--){
            Node succ =  addNode(root,a[i],null);


            if(succ != null) {
                succA[i] = succ.data;
           //     System.out.print(succ.data+",");
            }else{
                succA[i] = -1;
            //    System.out.print(-1+",");
            }
        }

        Arrays.stream(succA).forEach(e-> System.out.print(e+", "));

      //  printInorder(root);

      /*  int succA[] = new int [a.length];
        succA[a.length-1] = -1;

        Node succNode1 = findInorderSucc(root, 80);

        for(int i= a.length-2;i>=0;i--) {
            Node succNode = findInorderSucc(root, a[i]);
            if(succNode != null){
                succA[i] = succNode.data;
            }
            else{
                succA[i] = -1;
            }
        }

        Arrays.stream(succA).forEach(e-> System.out.print(e+","));
*/

    }

    private static void findNavive(int[] a) {

      for(int i=0;i<a.length;i++){
          int temp = Integer.MAX_VALUE;
          int j=i+1;
          for(;j<a.length;j++){
              if(a[j] >a[i]){
                  if(a[j] <temp){
                      temp = a[j];
                  }
              }


          }
          if(temp == Integer.MAX_VALUE){
              System.out.print(-1+", ");
          }
          else{
              System.out.print(temp+" ,");
          }

      }


    }

    private static Node findInorderSucc(Node root, int data) {

        Node temp = root;
        Node succ = null;
        
        Node pointerNode = findNode(root,data);
        if(pointerNode.right != null){
            int data1 = findMin(pointerNode.right);
            if(data1 == -1 ){
                return null;
            }
            else{
                return findNode(root, findMin(pointerNode.right));
            }
        }

        while(root != null){
            if(root.left != null){
                succ = root;
                root = root.left;
            }else{
                root = root.right;
            }
        }
        

        return succ;
    }

    private static int  findMin(Node node) {

        Node temp = node;
        Node left = node.left;
        Node right = node.right;

        int tempD = (node != null)?node.data:Integer.MAX_VALUE;
        int leftD = (left != null)?left.data:Integer.MAX_VALUE;
        int rightD = (right != null)?right.data:Integer.MAX_VALUE;

        return Math.min(Math.min(tempD,leftD),rightD);

    }

    private static Node findNode(Node root, int data) {
        if(root == null){
            return null;
        }

        if(root.data == data){
            return root;
        }

        Node temp = findNode(root.left, data);
        if(temp != null)
            return temp;
        return  findNode(root.right, data);

    }

    private static void printInorder(Node root) {

        if(root != null){
            printInorder(root.left);
            System.out.print(root.data+",");
            printInorder(root.right);
        }
    }

    private static Node addNode(Node root, int data, Node succ) {

        Node temp = root;
        Node preV = root;
        while(temp != null){
            preV = temp;
             if(data<temp.data){
                 temp = temp.left;
             }else{
                 temp = temp.right;
             }
        }

        Node newNode = new Node(data);
        if(preV.data <data){
            preV.right = newNode;
        }
        else{
            succ = preV;
            preV.left = newNode;
        }
        return succ;
    }


    static class Node{
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}


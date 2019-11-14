package tree;

public class SegmentTree {
    public static void main(String[] args) {
        int a []= {1, 3, 5, 7, 9, 11};

        int start = 0;
        int end = a.length-1;
        SegmentNode root = constructSegmentTree(a,start,end);

        //inOrder(root);

        int sum_in_range = getSum(root,0,3);
        System.out.println(sum_in_range);

        int diff = 3;
        updateNode(root,diff,0,3);
      //  inOrder(root);

         sum_in_range = getSum(root,0,3);
        System.out.println(sum_in_range);

    }

    private static void updateNode(SegmentNode root, int diff, int left, int right) {
        if(root != null){
            int nodeLeftRange = root.leftRange;
            int nodeRightRange = root.rightRange;

           /* if(left >right){
                return ;
            }
            if(left >nodeRightRange || right<nodeLeftRange){
                return ;
            }*/

            // 0,5
            // 0,3
            if(nodeLeftRange >= left && nodeRightRange >= right){
                root.data = root.data+diff;

            }

            updateNode(root.left,diff,left,right);
            updateNode(root.right,diff,left,right);
        }
    }

    private static int getSum(SegmentNode root, int left, int right) {

        if(left >right){
            return  0;
        }
        // if node range is completely outside of range ,return 0;

        int nodeLeftRange = root.leftRange;
        int nodeRightRange = root.rightRange;

        // out range

        if(left >nodeRightRange || right<nodeLeftRange){
            return 0;
        }


        //withinrange

        if(nodeLeftRange >= left && nodeRightRange <= right){
            return root.data;
        }

        return getSum(root.left,left,right)+ getSum(root.right,left,right);


    }

    private static void inOrder(SegmentNode root) {

        if(root != null){
            inOrder(root.left);
            System.out.println(root.data + "["+root.leftRange+","+root.rightRange+"]");
            inOrder(root.right);
        }
    }

    private static SegmentNode constructSegmentTree(int[] a, int start, int end) {

        if(start >end){
            return  null;
        }

        if(start == end){
            return new SegmentNode(a[start],start,end);
        }

        int mid = (start+end)/2;

        SegmentNode leftNode = constructSegmentTree(a,start,mid);
        SegmentNode rightNode = constructSegmentTree(a,mid+1,end);



        SegmentNode node = new SegmentNode(leftNode.data+rightNode.data,leftNode.leftRange,rightNode.rightRange);
        node.left = leftNode;
        node.right = rightNode;
        return  node;

    }



}

class SegmentNode{
    int data;
    int leftRange;
    int rightRange;

    SegmentNode left;
    SegmentNode right;

    public SegmentNode(int data, int leftRange, int rightRange) {
        this.data = data;
        this.leftRange = leftRange;
        this.rightRange = rightRange;
    }
}

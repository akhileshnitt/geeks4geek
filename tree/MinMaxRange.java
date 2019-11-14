package tree;

public class MinMaxRange {

    public static void main(String[] args) {
        int a [] = {1, 8, 5, 9, 6, 14, 2, 4, 3, 7};

        MinMaxNode root = constructTree(a,0,a.length-1);
       // inOrder(root);

        MaxMin result = maxMinRagneQuery(root,5,5);
        System.out.println(result.max +" ,"+result.min);

    }

    private static MaxMin maxMinRagneQuery(MinMaxNode root, int start, int end) {

        if(start >end){
            return  null;
        }

        // if complteley within

        if(root.leftR >= start && root.rightR <= end){
            return new MaxMin(root.max,root.min);
        }


        // if completely outSide


        if(start > root.rightR || end <root.leftR){
            return new MaxMin(Integer.MIN_VALUE,Integer.MAX_VALUE);
        }


        MaxMin leftM = maxMinRagneQuery(root.left,start,end);
        MaxMin rightM =  maxMinRagneQuery(root.right,start,end);

        int maxN = leftM.max>rightM.max ?leftM.max:rightM.max;
        int minN = leftM.min<rightM.min ?leftM.min:rightM.min;

        return new MaxMin(maxN,minN);

    }

    private static void inOrder(MinMaxNode root) {
        if(root != null){
            inOrder(root.left);
            System.out.println("Max :"+root.max +" min :"+root.min+" ["+root.leftR+","+root.rightR+"]");
            inOrder(root.right);
        }
    }

    private static MinMaxNode constructTree(int[] a, int start, int end) {
        if(start>end){
            return null;
        }
        if(start ==end){
            MinMaxNode node = new MinMaxNode(a[start],a[start],a[start],start,end);
            return node;
        }
        int mid = (start+end)/2;
        MinMaxNode lnode =  constructTree(a,start,mid);
        MinMaxNode rnode = constructTree(a,mid+1,end);

        int max = lnode.max>rnode.max ? lnode.max:rnode.max;
        int min = lnode.min<rnode.min ?lnode.min:rnode.min;
        MinMaxNode temp = new MinMaxNode(a[start],min,max,lnode.leftR,rnode.rightR);
        temp.left = lnode;
        temp.right = rnode;
        return temp;
    }


}
class MaxMin{
    int max;
    int min;

    public MaxMin(int max, int min) {
        this.max = max;
        this.min = min;
    }
}

class MinMaxNode{
    int data;
    int min;
    int max;
    int leftR;
    int rightR;

    MinMaxNode left;
    MinMaxNode right;

    public MinMaxNode(int data, int min, int max, int leftR, int rightR) {
        this.data = data;
        this.min = min;
        this.max = max;
        this.leftR = leftR;
        this.rightR = rightR;
    }
}

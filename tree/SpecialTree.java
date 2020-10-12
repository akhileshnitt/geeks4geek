package tree;

public class SpecialTree {

    static  int index =0;
    public static void main(String[] args) {
        int pre[] = {10, 30, 20, 5, 15};
        char preLN[] = {'N', 'N', 'L', 'L', 'L'};

        Node root = null;
        Index newIndex = new Index(0);
        root = contructTree(pre,preLN,root,newIndex);

        System.out.println(root);

    }

    private static Node contructTree(int[] pre, char[] preLN, Node temp, Index newIndex) {

        int index = newIndex.index;

        if (index == pre.length)
            return null;

        temp = new Node(pre[index]);

        (newIndex.index)++;



        if(preLN[index] == 'N') {
            temp.left = contructTree(pre, preLN,  temp.left, newIndex);
            temp.right = contructTree(pre, preLN,  temp.right, newIndex);
        }

        return temp;

    }

    static class Index{
        int index =0;

        public Index(int index) {
            this.index = index;
        }
    }
}

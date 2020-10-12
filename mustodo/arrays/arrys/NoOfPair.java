package mustodo.arrays.arrys;

public class NoOfPair {

    public static void main(String[] args) {
        int a [] = {2,1,6};
        int b [] = {1,5};

        int count = pair(a,b);
        System.out.println(count);
    }

    private static int pair(int[] a, int[] b) {
        int count =0;
        for (int i = 0; i < a.length; i++) {

            for(int j=0;j<b.length;j++){
                if(Math.pow(a[i],b[j])> Math.pow(b[j],a[i])){
                    count++;
                }
            }

        }
        return count;
    }
}

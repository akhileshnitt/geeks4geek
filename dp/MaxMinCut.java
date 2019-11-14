package dp;

public class MaxMinCut {

    public static void main(String[] args) {
        int a[] = {1,2,4,7,3,6,9};
        int k=4;

        int min = partiotion(a,a.length,k);
        System.out.println(min);

    }

    private static int partiotion(int[] a, int n, int k) {

        if(k==1){
            return sum(a,0,n-1);
        }
        if(n==1){
            return a[0];
        }

        int best = Integer.MAX_VALUE;

        for(int i=k-1;i<=n;i++){
            best = Math.min(best,Math.max(partiotion(a,i,k-1),sum(a,i,n-1)));
        }
        return best;
    }

    private static int sum(int[] a, int start, int end) {

        int sum =0;
        for(int i=start;i<=end;i++){
            sum +=a[i];
        }
        return sum;
    }
}

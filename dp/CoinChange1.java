package dp;

public class CoinChange1 {
    public static void main(String[] args) {
        int N = 10;
        int a [] = {2, 5, 3, 6};

        int count = countWays(a,N,a.length-1);
        System.out.println(count);
    }

    private static int countWays(int[] a, int n, int length) {

        if(n==0) return 1;

        if(n<0) return 0;

        if(length<0 && n>=1) return 0;

        return countWays(a,n-a[length],length) +countWays(a,n,length-1);
    }
}

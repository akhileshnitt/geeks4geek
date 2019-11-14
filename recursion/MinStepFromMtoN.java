package recursion;

public class MinStepFromMtoN {

    public static void main(String[] args) {
        int M = 4;
        int N = 6;

        int minStep= minStep(M,N);
        System.out.println(minStep);

    }

    private static int minStep(int m, int n) {


        if(m<=0 || n<=0) return 0;
        if(m == n){
            return 1;
        }
        return 1+Math.min(minStep(m-1,n),minStep(m*2,n));

    }
}

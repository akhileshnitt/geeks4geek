package array;

public class KadaneAlgo {


    public static void main(String[] args) {
        int a[] = {-2, -3, -4, -1, -2, 1, 5, -3};

        int largestContoguosSum = largestContoguosSum(a);

        System.out.println();
        System.out.println(largestContoguosSum);

    }

    private static int largestContoguosSum(int[] a) {


        int max_here=0;
        int max_so_far =Integer.MIN_VALUE;

        int start = 0,end = 0 ,s=0;


        for(int i=0;i<a.length;i++){
            max_here += a[i];

            if(max_here >max_so_far){
                max_so_far = max_here;
               end  =i;

            }
            if(max_here <0){
                start =i+1;
                max_here =0;
            }

        }

        System.out.println(start +" ----"+end);
        System.out.println();

        for(int i=start ;i<=end ;i++){
            System.out.print(a[i]+",");
        }

        return max_so_far;
    }


}

package array;

public class MaximumCircularSubArray {

    public static void main(String[] args) {
        int a[] = {8,-8,9,-9,10,-11,12};

       // 8,-8,9,-9,10,-11,12,8,-8,9,-9,10,-11,12

        //int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};

        int b[] = new int[a.length*2-1];

        for(int i=0;i<a.length;i++){
            b[i]  =a[i];
        }
        for(int i=a.length;i<2*a.length-1;i++){
            b[i]  =a[i-a.length];
        }


        int sum = findMaxSum(b);
        System.out.println(sum);



    }

    private static int findMaxSum(int[] b) {
        int startIndex=0;
        int endIndex=0;

        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;

        for(int i=0;i<b.length;i++){

            max_ending_here = max_ending_here+b[i];

            if(max_so_far <max_ending_here){
                max_so_far = max_ending_here;
                endIndex = i;
            }
            if(max_ending_here<0){
                max_ending_here = 0;
                startIndex = i+1;
            }


        }



        System.out.println(startIndex +" , "+endIndex);
        return max_so_far;

    }
}

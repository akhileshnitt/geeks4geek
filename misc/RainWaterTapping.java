package misc;

public class RainWaterTapping {

    public static void main(String[] args) {
      //  int a [] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int a [] = {3,0,0,0,0};


        //   method1(a);
        method2(a);

      //  System.out.println(method3(a,a.length));
    }

    private static int  method3(int arr[], int n) {
        // initialize output
        int result = 0;

        // maximum element on left and right
        int left_max = 0, right_max = 0;

        // indices to traverse the array
        int lo = 0, hi = n - 1;

        while (lo <= hi) {
            if (arr[lo] < arr[hi]) {
                if (arr[lo] > left_max)

                    // update max in left
                    left_max = arr[lo];
                else

                    // water on curr element =
                    // max - curr
                    result += left_max - arr[lo];
                lo++;
            }
            else {
                if (arr[hi] > right_max)

                    // update right maximum
                    right_max = arr[hi];

                else
                    result += right_max - arr[hi];
                hi--;
            }
        }

        return result;
    }

    private static void method2(int[] a) {

        int left [] = new int[a.length];
        left[0] = -1;
        int previous = a[0];
        for(int i=1;i<a.length;i++){
            if(a[i] <previous){
                left [i] = previous;
            }
            else{
                left [i] = a[i];
                previous = a[i];
            }
        }

        int right [] = new int[a.length];
        right[a.length-1] = -1;
        previous = a[a.length-1];
        for(int i=a.length-2;i>= 0;i--){
            if(a[i] < previous){
                right[i] = previous;
            }
            else{
                right[i] = a[i];
                previous = a[i];
            }
        }

        int totaolWater = 0;
        for(int i=0;i<a.length;i++){
            if(left[i] != -1 && right[i]!= -1){
                int min = Math.min(left[i],right[i]);
                totaolWater = totaolWater+ (min-a[i]);
            }
        }

        System.out.println(totaolWater);
    }

    private static void method1(int[] a) {
        int totaolWater = 0;
        for(int i=0;i<a.length;i++){
            int findMin = findMin(a,i);
            if(findMin >0){
                totaolWater = totaolWater+  (findMin-a[i]);
            }
        }

        System.out.println(totaolWater);
    }

    private static int findMin(int[] a, int index) {

        int left = Integer.MIN_VALUE;
        for(int i=0;i<index;i++){
            if(a[i]>a[index] && a[i]>left){
                left = a[i];
            }
        }
        int right = Integer.MIN_VALUE;
        for(int i=index+1;i<a.length;i++){
            if(a[i]>a[index] && a[i]>right){
                right = a[i];
            }
        }
        return Math.min(left,right);
    }
}

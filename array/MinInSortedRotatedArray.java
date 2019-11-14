package array;

public class MinInSortedRotatedArray {
    public static void main(String[] args) {
        //int a [] = {5,6,1,2,3,4};
       // int a [] = {2};
       // int a[]= {5,4,3,2,1};
                  // 1,2 3,4,5,6,7,8
        int a[] = {2,3,4,5,6,7,8,1};





        // 2,3,6,12,15,18
        // 18,2,3,6,12,15
        // 15,18,2,3,6,12

        int b[] = {6,5,4,3,2,1};
        int min = findMin(b,0,b.length-1);
        System.out.println(min);

        System.out.println("No of rotation");

        int noOfRotation = findNoOfRotation(b,0,b.length-1);
        System.out.println(noOfRotation);
    }

    private static int findNoOfRotation(int[] a, int low, int high) {
        int indexOfMin =  indexOfMin(a,low,high);
        return indexOfMin;

    }

    private static int indexOfMin(int[] a, int low, int high) {
        if(low == high){
            return low;
        }

        // int mid =  (low +high)/2;
        int mid =  low +(high -low )/2;

        if(mid-1 >=0 && ( (a[mid-1] > a[mid]) && (a[mid] < a[high]))){
            return mid;
        }
        else {
            if(a[mid] > a[high]){
                return indexOfMin(a,mid+1,high);
            }
            else {
                return indexOfMin(a,low,mid);
            }
        }
    }



    private static int findMin(int[] a, int low, int high) {
        if(low == high){
            return a[low];
        }

       // int mid =  (low +high)/2;
        int mid =  low +(high -low )/2;

        if(mid-1 >=0 && ( (a[mid-1] > a[mid]) && (a[mid] < a[high]))){
            return a[mid];
        }
        else {
            if(a[mid] > a[high]){
                return findMin(a,mid+1,high);
            }
            else {
                return findMin(a,low,mid);
            }
        }
    }
}

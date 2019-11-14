package array;

public class CountInSortedArray {

    public static void main(String[] args) {
        int a [] = {1,1,1,1,2,2,2,2,2,3,3,3,4,5};
        int no = 1;

       // System.out.println(findFirst(a,no,0,a.length-1));
       // System.out.println(findLast(a,no,0,a.length-1));
        int totalCount = computeCount(a,no);
        System.out.println(totalCount);

    }

    private static int computeCount(int[] a, int no) {

        return findLast(a,no,0,a.length-1)-
                findFirst(a,no,0,a.length-1) +1;

    }

    private static int findFirst(int[] a, int no, int low, int high) {

         int mid = (low+high)/2;


         if(a[mid] == no){
             if(mid-1 >=0 && a[mid-1] == no){
                 return findFirst(a,no,low,mid);
             }
             else {
                 return mid;
             }
         }
         else{
             if(a[mid] < no){
                 return findFirst(a,no,mid+1,high);
             }
             else{
                 return  findFirst(a,no,low,mid);
             }
         }


    }

    private static int findLast(int[] a, int no, int low, int high) {

        int mid = (low+high)/2;

        if(a[mid] == no){
            if(mid+1 <a.length && a[mid+1] == no ){
                return findLast(a,no,mid+1,high);

            }
            else {
                return mid;
            }
        }
        else{
            if(a[mid] >no){
                return findLast(a,no,low,mid);
            }
            else{
                return findLast(a,no,mid,high);
            }
        }

    }


}

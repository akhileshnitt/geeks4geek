package array;

public class SearchInSortedRotated {
    public static void main(String[] args) {

       // int a[] = {3,4,5,1,2};
       // int a[] = {1,2,3,4,5};
        int a[] = {7,8,9,10,11,12,13};
        int key = 11;

        int index=findIndexOfKey(a,key,0,a.length-1);
        System.out.println(index);
    }

    private static int findIndexOfKey(int[] a, int key,int low,int high) {


        int mid = low + (high-low)/2;

        if(a[mid] == key){
            return mid;
        }
        else{

            if(a[0] > key){
                return findIndexOfKey(a,key,mid+1,high);
            }
            else
                return findIndexOfKey(a,key,low,mid);
        }
        }
}

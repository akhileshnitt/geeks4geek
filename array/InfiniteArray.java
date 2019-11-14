package array;

public class InfiniteArray {
    public static void main(String[] args) {
        int a []={3,5,7,9,10,90,100,130,140,160,170};
        int key = 90;

        int index = findIndexOfKey(a,key,0,1);
        System.out.println(index);


    }

    private static int findIndexOfKey(int[] a, int key,int low,int high) {

        while(low <high) {
            if(low>a.length ||high>a.length) return -1;


            if (a[low] == key) {
                return low;
            }
            if (a[high] == key) {
                return high;
            }

            if (a[high] < key) {
                low = high;
                high = high * 2;

            }
            else{
                high = high/2;
            }

            int index =  findIndexBinary(a, key, low, high);
            if(index != -1) {
                return  index;
            }
        }
        return  -1;


    }

    private static int findIndexBinary(int[] a, int key, int low, int high) {

        if(low>a.length ||high>a.length) return -1;

        if(low >high) return  -1;
        int mid = low+ (high-low)/2;

        if(a[mid] == key){
            return mid;
        }
        if(a[mid]<key){
            return  findIndexBinary(a,key,mid+1,high);
        }
        else{
           return findIndexBinary(a,key,low,mid-1);
        }

    }

}

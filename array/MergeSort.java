package array;

public class MergeSort {
    static int k=0;
    public static void main(String[] args) {
        int a [] = {34,10,4,3,11,99,5};
        mergesort(a,0,a.length-1);

        for(int i:a){
            System.out.print(i+",");
        }
    }

    private static void mergesort(int[] a, int low, int high) {
        if(low<high){
            int mid = (low+high)/2;

            mergesort(a,low,mid);
            mergesort(a,mid+1,high);
            merge(a,low,mid,high);
        }
    }

    private static void merge(int[] a, int low, int mid, int high) {

        int l1 = mid-low+1;
        int l2 = high-mid;

        int left [] = new int [l1];
        int right [] = new int [l2];

        int m=0;
        for(int i=low;i<=mid;i++){
            left[m++]  = a[i];
        }

        m=0;
        for(int i=mid+1;i<=high;i++){
            right[m++] = a[i];
        }

        int k=low;

        int i=0,j=0;
        while(i<left.length && j<right.length){
            if(left[i]<right[j]){
                a[k++]= left[i++];
            }
            else {
                a[k++]= right[j++];
            }
        }

        while(i<left.length){
            a[k++]= left[i++];
        }

        while(j<right.length){
            a[k++]= right[j++];
        }



    }


}

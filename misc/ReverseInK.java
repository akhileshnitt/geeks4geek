package misc;

public class ReverseInK {

    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,7,8,9};
        int k=10;

        for(int i=0;i<a.length;i=i+k){
            swap(a,i,i+k-1);

        }

        for(int m :a){
            System.out.print(m+",");
        }

    }

    private static void swap(int[] a, int i, int j) {
        if(j>a.length-1) return;
     //   System.out.println(i+" - "+j);

        for(int k=i;k<=j;k++){
            if(i!=j) {
                swap1(a, i, j);
                i++;
                j--;
            }
        }
    }

    private static void swap1(int[] a, int i, int j) {

        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }


}

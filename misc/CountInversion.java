package misc;

public class CountInversion {
    public static void main(String[] args) {
        int a[] = {3,1,2};

        int inversionCount= 0;
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[j]<a[i]){
                    inversionCount++;
                }
            }
        }
        System.out.println(inversionCount);
    }
}

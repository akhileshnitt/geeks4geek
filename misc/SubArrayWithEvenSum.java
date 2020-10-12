package misc;

public class SubArrayWithEvenSum {
    public static void main(String[] args) {
        int a[]={1,2,2,3,4,1};

        method1(a);

    }

    private static void method2(int[] a) {

        for(int i=0;i<a.length;i++){

        }
    }

    private static void method1(int[] a) {
        int total=0;

        for(int i=0;i<a.length;i++){
            int sum =0;
            for(int j=i;j<a.length;j++){
                sum+=a[j];
                if(sum %2 == 0){
                    for(int k=i;k<=j;k++){
                        System.out.print(a[k]+",");
                    }
                    System.out.println();
                    total++;
                }
            }
        }
        System.out.println(total);
    }

}

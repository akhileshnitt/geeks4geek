package mustodo.arrays.arrys;

public class Leader {

    public static void main(String[] args) {
        int a [] = {16, 17 ,4, 3 ,5, 2};

        //int a [] = {7, 4 ,5 ,7 ,3};

        int max = a[a.length-1];
        System.out.print(max+",");
        for(int i=a.length-2;i>=0;i--){
            if(a[i]>=max){
                max =a[i];
                System.out.print(max+",");
            }
        }
        /*System.out.println("Leader");
        int temp = a[0];
        System.out.print(temp+",");
        for(int i=1;i<a.length;i++){
            if(temp != a[i]){
                temp = a[i];
                System.out.print(a[i]+",");
            }
        }*/


    }
}

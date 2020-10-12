package misc;

public class BillBoard {

    public static void main(String[] args) {
        /*int x[]       = {6, 7, 12, 13, 14};
        int revenue[] = {5, 6, 5,  3,  1};
*/

        int[] x = new int[]{6, 7, 12, 13, 14};
        int[] revenue = new int[]{5, 6, 5, 3, 1};
        int t = 5;

        int maxRevenue = Integer.MIN_VALUE;

        for(int i=1;i<x.length;i++){

            int distance = x[i-1];
            int revenue1 = revenue[i-1];

            for(int j=i;j<x.length;j++){

                if(distance+t < x[j]){
                    revenue1 += revenue[j];
                    distance = x[j];
                }

            }

            if(revenue1 >maxRevenue){
                maxRevenue = revenue1;
            }
        }


        System.out.println(maxRevenue);


    }
}

package mustodo.arrays.arrys;

import com.sun.tools.javac.util.Pair;

public class SubArrayWithGivenSum {

    public static void main(String[] args) {
       // int arr[] = {1, 4, 20, 3, 10, 5}, add = 33;

        //int arr[] = {1, 4, 0, 0, 3, 10, 5}, add = 7;

        int arr[] = {1, 4}, sum = 0;
      // int  arr[] = {10, 2, -2, -20, 10}, add = -10;

      //  int arr[] = {-10, 0, 2, -2, -20, 10}, add = 20;

        //Pair pair = findIndex(arr, add);

        Pair pair = findIndex1(arr, sum);
        if((int)pair.fst ==-1){
            System.out.println("Not found");
        }else{
            System.out.println(pair.fst+","+pair.snd);
        }
    }


    //{1, 4, 20, 3, 10, 5}, add = 33
    private static Pair findIndex1(int[] a, int sum) {

        int tSum =0;
        int startIndex =0 ;
        for(int i=0;i<a.length;i++){
            tSum += a[i];
            if(tSum == sum){
                return new Pair(startIndex,i);
            }
            else if(tSum >sum){
                while(tSum >sum){
                    tSum = tSum -a[startIndex];

                    startIndex++;
                    if(tSum == sum){
                        return new Pair(startIndex,i);
                    }
                }
            }
        }

        return new Pair<>(-1,-1);
    }

    private static Pair findIndex(int[] arr, int sum) {
        for(int i=0;i<arr.length;i++){
            int tSum=0;
            tSum = tSum+arr[i];
            for(int j=i+1;j< arr.length;j++){
                tSum = tSum+arr[j];
              /*  if(tSum >add) {
                    break;
                }
                else*/ if(tSum ==sum){
                    return new Pair<>(i,j);
                }
            }
        }
        return new Pair<>(-1,-1);
    }
}

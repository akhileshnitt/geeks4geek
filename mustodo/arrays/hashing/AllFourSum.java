package mustodo.arrays.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AllFourSum {

    public static void main(String[] args) {
       // int a [] = {10, 2, 3, 4, 5, 9, 7, 8};
        //int a [] = {10 ,2 ,3 ,4 ,5 ,7 ,8};
       // int add = 23;
        int a[] = { 10, 20, 30, 40, 1, 2 };
        int sum = 91;

     //   generateQuadOn4(a,add);
       // System.out.println("*************");
      //  generateQuadOn3(a,add);
     //   System.out.println("**************");
        generateQuadOn2(a,sum);

      /* int a[] = {0 ,0, 2, 1, 1 };
       int add = 3;*/

        /*List<Integer> list  = new ArrayList<>();

        boolean found = allFourSum(a,add,list,0);
        System.out.println();
        System.out.println(found);*/

    }

    private static void generateQuadOn2(int[] a, int sum) {

        Map<Integer,Indexes> map = new HashMap<>();


        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){

                int tempSum = a[i]+a[j];

                if(map.get(sum- tempSum) != null){

                    Indexes  p = map.get(sum- tempSum);
                    if (p.first != i && p.first != j
                            && p.second != i && p.second != j) {

                        System.out.println(a[i] + "," + a[j] + "," + a[p.first] + "," + a[p.second] + ",");
                        break;

                    }

                   // System.out.println();
                }
                else if(map.get(tempSum) == null){
                    Indexes indexes = new Indexes(i,j);
                    map.put(tempSum,indexes);
                }

            }
        }


    }

    private static boolean isSame(Indexes index, int i, int j) {
        if(index.first ==i ||index.first ==j){
            if(index.second ==i || index.second == j){
                return true;
            }
        }
        return false;
    }

    private static void generateQuadOn3(int[] a, int sum) {

        Arrays.sort(a);
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                int tempSum = a[i]+a[j];

                int l = j+1;
                int r = a.length-1;
                while(l<r){
                    if(tempSum+a[l]+a[r] == sum){
                        System.out.println(a[i]+","+a[j]+","+a[l]+","+a[r]);
                        l++;
                        r--;
                    }
                    else if(tempSum+a[l]+a[r] < sum){
                        l++;
                    }
                    else{
                        r--;
                    }
                }
            }
        }
    }

    private static void generateQuadOn4(int[] a, int sum) {

        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                for(int k=j+1;k<a.length;k++){
                    for(int l=k+1;l<a.length;l++){
                        if(a[i]+a[j]+a[k]+a[l] ==sum){
                            System.out.println(a[i]+","+a[j]+","+a[k]+","+a[l]);
                        }
                    }
                }
            }
        }
    }

    private static boolean allFourSum(int[] a, int sum, List<Integer> list,int index) {

        if(sum <0 || index >=a.length) return false;


        if(sum == 0){
          //  System.out.println("found");
            list.forEach(e-> System.out.print(e+","));
            System.out.println();
            return true;
        }

        list.add(a[index]);
        boolean isFound = allFourSum(a,sum-a[index],list,index+1);
        if(!isFound){
            list.remove(list.size()-1);
            isFound=   allFourSum(a,sum,list,index+1);
        }
        return isFound;
    }

    static class Result {
        int i,j,k,l;

        public Result(int i, int j, int k, int l) {
            this.i = i;
            this.j = j;
            this.k = k;
            this.l = l;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Result result = (Result) o;

            return (i == result.i ||i == result.j||i == result.k||i == result.l)||
                    (j == result.j||j == result.i||j == result.k||j == result.l) ||
                    (k == result.k ||k == result.i||k == result.j||k == result.l)||
                    (l == result.l||l == result.i||l == result.j||l == result.k);
        }

        /*@Override
        public int hashCode() {
            return Objects.hash(first, second, k, l);
        }*/

        @Override
        public String toString() {
            return i+","+j+","+k+","+l;
        }
    }
    static   class Indexes{
        int first;
        int second;

        public Indexes(int i, int j) {
            this.first = i;
            this.second = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Indexes indexes = (Indexes) o;
            return first == indexes.first &&
                    second == indexes.second;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }
}

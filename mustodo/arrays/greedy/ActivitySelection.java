package mustodo.arrays.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ActivitySelection {

    public static void main(String[] args) {
        int a[] = {1 ,3, 2, 5, 8, 5};
        int b[] = {2, 4, 6, 7, 9, 9};

       /* int a[]  =  {10, 12, 20};
        int b[] =  {20, 25, 30};
*/
        //method1(a, b);

        method2(a,b);
    }

    private static void method2(int[] start, int[] finish) {
        //assume its sorted by finish time

        int i=0;
        System.out.println(start[0]+","+finish[0]);

        for(int j=1;j<finish.length;j++){
            if(start[j]>=finish[i]){
                System.out.println(start[j]+","+finish[j]);
                i=j;
            }
        }
    }

    private static void method1(int[] a, int[] b) {
        List<Pair> pairs = new ArrayList<>();
        for(int i=0;i<a.length;i++)
        pairs.add(new Pair(a[i],b[i]));

        Collections.sort(pairs, (p1, p2)->{
            if(p1.second >p2.second) return 1;
            return -1;
         });

        List<Pair> acivities = new ArrayList<>();
        Pair initPair = pairs.remove(0);
        acivities.add(initPair);

        /// find next Pair
        while(initPair != null) {
            initPair = findNextPair(pairs, initPair);
            if(initPair != null)
            acivities.add(initPair);
        }

        System.out.println(acivities);
    }

    private static Pair findNextPair(List<Pair> pairs, Pair initPair) {
        for(int i=0;i<pairs.size();i++){
            if(pairs.get(i).first >= initPair.second){
                return pairs.get(i);
            }
        }
        return null;
    }

    static class Pair{
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "first=" + first +
                    ", second=" + second +
                    '}';
        }
    }
}

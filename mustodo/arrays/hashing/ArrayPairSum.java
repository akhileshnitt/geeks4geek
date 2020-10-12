package mustodo.arrays.hashing;

import java.util.ArrayList;
import java.util.List;

public class ArrayPairSum {


    public static void main(String[] args) {

        /*int a []= {9 ,7, 5, 3};
        int k = 6;*/

        int a []= {91 ,74, 66, 48};
        int k = 10;
        List<Pair> list  = new ArrayList<>();

        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                int sum = a[i]+a[j];
                if(sum %k ==0){
                    list.add(new Pair(a[i],a[j]));
                }
            }
        }

        if(list.size()%2 ==0){
            System.out.println("true");
        }else{
            System.out.println("false");
        }

    }

    static class Pair{
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}

package mustodo.arrays.hashing;

import java.util.HashMap;
import java.util.Map;

public class CommonElement {

    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();

        int a[]= {1, 5, 10, 20, 40 ,80};
        int b[] = {6, 7, 20 ,80 ,100};
        int c[] = {3, 4 ,15 ,20, 30, 70 ,80, 120};

        method2(a,b,c);

        //method1(map, a, b, c);
    }

    private static void method2(int[] a, int[] b, int[] c) {

        for(int i=0;i<a.length;i++){
            if(isFoundBinary(a[i],b)){
                if(isFoundBinary(a[i],c)){
                    System.out.print(a[i]+",");
                }
            }
        }
    }

    private static boolean isFoundBinary(int num, int[] b) {
        return search(num,b,0,b.length-1);
    }

    private static boolean search(int num, int[] arr, int low, int high) {
        if(low<high){
            int mid = (low+high)/2;

            if(arr[mid] == num) return true;

            if(arr[mid] >num) {
                return search(num, arr, low, mid);
            }
            else {
                return search(num, arr, mid + 1, high);
            }
        }
        return false;
    }

    private static boolean isFound(int num, int[] arr) {
        for(int i=0;i< arr.length;i++){
            if(arr[i] == num) return true;
        }
        return false;
    }

    private static void method1(Map<Integer, Integer> map, int[] a, int[] b, int[] c) {
        populateMap(map, a);
        populateMap(map, b);
        populateMap(map, c);

        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue() ==3){
                System.out.print(entry.getKey()+",");
            }
        }
    }

    private static void populateMap(Map<Integer, Integer> map, int[] a) {
        for(int i=0;i<a.length;i++){
            if(map.get(a[i]) == null){
                map.put(a[i],1);
            }
            else{
                int count = map.get(a[i]);
                map.put(a[i],count+1);
            }
        }
    }
}

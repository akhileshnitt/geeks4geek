package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EqualSumKSubSet {

    public static void main(String[] args) {
        int a [] = {2, 1, 4, 5, 3, 3};
        int k=2;
        int sum = Arrays.stream(a).sum();

       // findKSubSet1(a,add,0,k);

      //  boolean isEqual = findKSubSet(a,0,add,0);
        boolean elements [] = new boolean[a.length];
        List<List<Integer>> subSetList = new ArrayList<>();
        boolean isFound = findKSubSet1(a,elements,sum,0,k,subSetList);
        System.out.println(isFound);
    }

    private static boolean findKSubSet1(int[] a, boolean[] elements, int sum, int index, int k, List<List<Integer>> subSetList) {
        if(k>a.length-1) return false;
        if(sum %k != 0) return false;
        int tSum = sum/k;

        generateSubSet(a, elements, tSum, index,  subSetList,k);
        int totalSum =0;
        for(int i=0;i<k-1;i++){
            List<Integer> l = subSetList.get(i);
            System.out.println(l);
            totalSum = totalSum+l.stream().reduce(0,Integer::sum);
        }

        if(totalSum  == sum-tSum) {
            System.out.print("[");
            for(int i=0;i<elements.length;i++){
                if(!elements[i]){
                    System.out.print(a[i]+",");
                }
            }
            System.out.println("]");
            return true;
        }
        return false;
    }

    private static void generateSubSet(int[] a, boolean[] elements, int sum, int index, List<List<Integer>> subSetList, int k) {
        for(int j=0;j<k-1;j++) {
            int tempSum = 0;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < a.length; i++) {

                if (!elements[i]) {

                    if (tempSum + a[i] < sum) {
                        tempSum = tempSum + a[i];
                        list.add(a[i]);
                        elements[i] = true;
                    } else {
                        if (tempSum+a[i] == sum) {
                            list.add(a[i]);
                            elements[i] = true;
                            subSetList.add(list);
                            break;
                        } else if (list.size() > 0) {
                            int e = list.get(list.size() - 1);
                            list.remove(list.size() - 1);
                            elements[i - 1] = false;
                            tempSum = tempSum - e;
                            i--;

                        }
                    }
                }
            }
        }
    }

    private static boolean findKSubSet(int[] a, int sum, int totalSum, int index) {
        if(sum == totalSum) return true;

        if(index >=a.length || sum >totalSum ) return false;

        return  findKSubSet(a,sum+a[index],totalSum-a[index],index+1)||
                findKSubSet(a,sum,totalSum,index+1);
    }



}

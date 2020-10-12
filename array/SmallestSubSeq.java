package array;

import java.util.ArrayList;
import java.util.List;

public class SmallestSubSeq {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(8);

        int targetSum = 12;

        List<SumIndex> sumIndex = findTargetIndex(list,targetSum);
        for(SumIndex sumI:sumIndex){
            System.out.println("["+sumI.getStartIndex() +", "+sumI.getEndIndex()+"]");
        }



    }

    private static List<SumIndex> findTargetIndex(List<Integer> list, int targetSum) {

        List<SumIndex> indices = new ArrayList<>();

        for(int i=0;i<list.size();i++){
            int sum= list.get(i);
            for(int j=i+1;j<list.size();j++){
                sum += list.get(j);
                if(sum == targetSum){
                    indices.add(new SumIndex(i,j));
                    break;
                }
            }
        }
        if(indices.size() ==0){
            indices.add(new SumIndex(-1,-1));
        }
        return indices;
    }
}

class SumIndex {

    private int startIndex;
    private int endIndex;

    public SumIndex(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }
}

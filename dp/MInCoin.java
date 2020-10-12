package dp;

import java.util.ArrayList;
import java.util.List;

public class MInCoin {
    public static void main(String[] args) {
        int [] demo = new int[]{ 9, 6, 5, 1};

        int sum = 11;
        List<Integer> notes = new ArrayList<>();
        while(sum !=0){
            int maxDemo = findNearest(demo,sum);
            if(maxDemo == -1) break;
            notes.add(maxDemo);
            sum = sum - maxDemo;
        }
        System.out.println(notes);
    }

    private static int findNearest(int[] demo, int sum) {
        if(sum > demo[demo.length-1]) return demo[demo.length-1];
        for(int i=0;i<demo.length;i++){
            if(demo[i]>sum){
                return demo[i-1];
            }
        }
        return -1;
    }
}

package array;

public class MInJump {

    static int min_jump = Integer.MAX_VALUE;
    public static void main(String[] args) {
       // int a []={1,3,5,8,9,2,6,7,6,8,9};
        int a []={1,2,3,4};
        findMinJump(a,0,0);
        System.out.println(min_jump);

    }

    private static void findMinJump(int[] a, int currIndex, int step) {

        if(currIndex >= a.length) return;

        if(currIndex == a.length-1){

            if(step<min_jump){
                min_jump = step;
            }
        }

        if(a[currIndex] == 0 && currIndex != a.length-1) return;

        for(int i=1;i<=a[currIndex];i++){
            findMinJump(a,currIndex+i,step+1);
        }
    }
}

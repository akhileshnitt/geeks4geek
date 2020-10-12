package array;

public class EqualSum {

    public static void main(String[] args) {
       // int a [] = {5,5,1,11};
       // 22/2 = 11
        //int add = 11;



        int a [] = {1,5,3};
        int sum = 5;

        int [] path = new int [100];
        int pathLength=0;

        boolean isExist = equalSubSubSet(a,0,sum,path,pathLength);
        System.out.println(isExist);
    }

    private static boolean equalSubSubSet(int[] a, int index, int sum,int [] path,int pathLength) {

        if(sum <0 || index >a.length-1) {
            return false;
        }


        if(sum ==0){
            for(int i=0;i<pathLength;i++){
                System.out.print(path[i]+",");
            }
            System.out.println();
            return true;
        }


        if(sum-a[index] >= 0) {
            path[pathLength++] = a[index];
        }



        return equalSubSubSet(a,index+1,sum-a[index],path,pathLength)|| equalSubSubSet(a,index+1,sum,path,pathLength);

    }

}

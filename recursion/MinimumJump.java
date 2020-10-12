package recursion;

public class MinimumJump {

    static int minstep = Integer.MAX_VALUE;
    public static void main(String[] args) {
        //int a [] = {0,1,2,3,4};
       // int a[] = { 1, 3, 6, 1, 0, 9 };
        int a[] =  {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};

        minJump(a,0,0);



        if(minstep == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else{
            System.out.println(minstep);
        }
    }

    private static void minJump(int[] a, int index, int step) {

        if(index >= a.length-1){
            if(step<minstep){
                minstep = step;
           //     System.out.println(minstep);
            }
            return;
        }

      for(int i=index+1;i<=a[index]+index && i<a.length;i++){

          step = step+1;
          minJump(a,i,step);
          step = step-1;
      }



    }
}

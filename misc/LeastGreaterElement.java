package misc;

public class LeastGreaterElement {

    public static void main(String[] args) {
        int a [] = {8, 58, 71, 18, 31, 32, 63, 92,43, 3, 91, 93, 25, 80, 28};

        for(int i=0;i<a.length;i++){
           int b = findNextGreater(a,i+1,a[i]);
            System.out.print(b+",");
        }



    }


    //18, 63, 80, 25, 32, 43, 80, 93, 80, 25, 93, -1, 28, -1, -1
    //18,63,80,   25, 32,43,  80, 93, 80, 25, 93, 2147483647,28,2147483647,-1,
    private static int findNextGreater(int[] a, int index, int number) {
      if(index >= a.length) return -1;

      int min = Integer.MAX_VALUE;
      for(int i=index;i<a.length;i++){
          if(a[i]>number){
              if(a[i]<min){
                  min = a[i];

              }
          }
      }
      if(min == Integer.MAX_VALUE) return -1;
      return min;
    }
}

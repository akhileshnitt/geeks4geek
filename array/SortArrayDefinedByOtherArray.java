package array;

import java.util.Arrays;

public class SortArrayDefinedByOtherArray {

    public static void main(String[] args) {
        Integer a[] = {2,1,2,5,7,1,9,3,6,8,8};
        Integer b[] = {2,1,8,3};

        Arrays.sort(a,(Integer o1,Integer o2)->{

            int indexO1 = findIndex(o1,b);
            int indexO2 = findIndex(o2,b);

            if(indexO1 == -1 && indexO2 == -1){
                if(o1<o2) return -1;
                return 1;
            }

            if(indexO1 != -1 && indexO2 != -1){
                if(indexO1 <indexO2){
                    return -1;
                }
                else{
                    return 1;
                }

            }
            else if(indexO1 ==-1 ){
                return 1;

            }
            return -1;

        });

        Arrays.stream(a).forEach(e-> System.out.print(e+" ,"));
    }

    private static int findIndex(Integer o1, Integer[] b) {
        for(int k=0;k<b.length;k++){
            if(o1 == b[k]){
                return k;
            }
        }
        return -1;
    }
}

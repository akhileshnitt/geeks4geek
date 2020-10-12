package array;

public class LongestIncreasingSeqDroppingAtMostOne {


    public static void main(String[] args) {
        int a [] = {3 ,4 , 2 , 1, 5 ,7 ,8};

       // int a [] = {2,4,1};

        int atmost = 0;

        int maxLength = 1;
        for(int i=1;i<a.length;i++){

            if(a[i] >a[i-1]){
                maxLength ++;
            }
            else{
                if(atmost == 0){
                    atmost++;
                }

                else if(atmost >=1){
                    maxLength = 1;
                    atmost =0;
                  //  i--;
                }
            }
        }

        System.out.println(maxLength);
    }
}

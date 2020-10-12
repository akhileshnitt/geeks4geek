package mustodo.arrays.arrys;

public class SubArray {
    public static void main(String[] args) {
       /* int input [] = {1 ,2 ,3 ,7 ,5};
        int add = 12;*/


       int input [] = {10, 2, -2, -20, 10};
        int sum = -10;


      //  Arrays.sort(input);

        int reqSum=0;
        boolean found =false;

        for(int i=0;i< input.length;i++){
            if(reqSum <sum){
                reqSum +=input[i];

            }
            int j=0;
             if(reqSum >sum) {

                while(reqSum>sum ){
                    reqSum -= input[j];
                    j++;
                }
            }
            if(reqSum == sum){
                found = true;
                System.out.println("add found :"+reqSum+" "+j+","+i);
                break;
            }
        }
        if(!found){
            System.out.println("add Not found ");
        }
    }
}

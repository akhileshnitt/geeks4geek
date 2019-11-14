package recursion;

public class AllComibantionOfR {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4};
        int r = 2;

        int result[] = new int[r];
        int resultIndex=0, inputIdex = 0;

        printAllCombinationOfR(input, inputIdex, r, result, resultIndex);
    }

    private static void printAllCombinationOfR(int[] input, int inputIdex, int r, int[] result, int resultIndex) {

          if(resultIndex == r){
            for(int i=0;i<r;i++){
                System.out.print(result[i]+",");

            }
            System.out.println();
            return;
        }
        if(resultIndex <r && inputIdex <input.length) {
            //     System.out.println("resultIndex :"+resultIndex+" inputIdex: "+inputIdex);
            result[resultIndex] = input[inputIdex];


            printAllCombinationOfR(input, inputIdex + 1, r, result, resultIndex + 1);
            printAllCombinationOfR(input, inputIdex + 1, r, result, resultIndex);
        }
    }
}

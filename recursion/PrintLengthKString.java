package recursion;

public class PrintLengthKString {

    public static void main(String[] args) {
        //char [] input = {'a','b'};
        char set2[] = {'a', 'b', 'c', 'd'};
        int k=4;

        printAllCombination(set2,k,"");
    }

    private static void printAllCombination(char[] input, int k, String result) {


        if(result.length() ==k) {
            System.out.println(result);
            return;
        }

        for(int i=0;i<input.length;i++){
             String newPrefix  = result+input[i];
            printAllCombination(input,k,result+input[i]);
        }
    }
}

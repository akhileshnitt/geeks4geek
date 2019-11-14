package recursion;

public class AllCombinationOfNumber {


    public static void main(String[] args) {
        int number = 3;

        printAllCombination(number,"");
    }

    private static void printAllCombination(int number, String result) {
        if(number ==0){
            System.out.println(result);

        }
        if(number <0) return;

        for(int i=1;i<=number;i++){
            result+=i+"+";
            printAllCombination(number-i,result);
        }
    }
}

package recursion;

public class Recursion1 {
    public static void main(String[] args) {
    //   printNumber(1);

        int num = fact(5);
        System.out.println(num);

         int nnum  = tailFact(5,1);
        System.out.println(nnum);
    }

    private static int tailFact(int num, int result) {

        if(num ==0) return result;
        return tailFact(num-1,num*result);
    }

    private static int fact(int number) {
        if(number==0) return 1;
        return number*fact(number-1);
    }

    private static void printNumber(int number) {
        if(number>10) return;
        System.out.println(number);
        printNumber(number+1);
    }
}

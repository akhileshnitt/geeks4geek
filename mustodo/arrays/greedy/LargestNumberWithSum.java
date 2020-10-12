package mustodo.arrays.greedy;

public class LargestNumberWithSum {
    public static void main(String[] args) {
        int  noOfDigit = 3;
        int  sum = 20;

        int largestNumber = largestNumber(noOfDigit,sum);
        System.out.println(largestNumber);
    }

    private static int largestNumber(int noOfDigit, int sum) {
        if(sum > maxSum(noOfDigit) || sum<1) return -1;

        String largest = "";

        while(sum >9){
            largest +=9;
            sum = sum -9;

        }
        largest +=sum;

        largest = addPadding(largest,noOfDigit);


        return Integer.valueOf(largest);

    }

    private static String addPadding(String largest, int noOfDigit) {
        for(int i=0;i<noOfDigit-largest.length();i++){
            largest +=0;
        }
        return largest;
    }

    private static int maxSum(int noOfDigit) {
        int  sum=0;
        for(int i=0;i<noOfDigit;i++){
            sum +=9;
        }
        return sum;
    }
}

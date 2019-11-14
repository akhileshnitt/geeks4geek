package recursion;

public class DiceSum {
    static int noOfWays;

    public static void main(String[] args) {

        int faces = 6;
        int thrws = 3;
        int sum = 12;

        findNoOfWays(faces, thrws, sum);
        System.out.println(noOfWays);

    }

    private static void findNoOfWays(int faces, int thrws, int sum) {

        if(thrws <0 || sum<0) return;
        if (thrws == 0 && sum == 0) {
            noOfWays++;

        }
        for (int i = 1; i <= faces; i++) {
            findNoOfWays(faces, thrws - 1, sum - i);
        }
    }

}

package recursion;

public class NoOfWays {

    static int noOfWays = 0;

    public static void main(String[] args) {

        int face = 6;
        int noOfDice = 3;
        int sum = 8;
       // countNumberOfWays(face, noOfDice, 8);

        countNumberOfWays(4, 3, 5);
        System.out.println(noOfWays);

        /*System.out.println(findWays(4, 2, 1));
        System.out.println(findWays(2, 2, 3));
        System.out.println(findWays(6, 3, 8));
        System.out.println(findWays(4, 2, 5));
        System.out.println(findWays(4, 3, 5));*/

    }

    private static void countNumberOfWays(int face, int noOfDice, int sum) {

        if(sum <0 || noOfDice <0) return;

        if (sum == 0 && noOfDice == 0) {
            noOfWays = noOfWays + 1;
        }
        for (int j = 1; j <= face; j++) {
            countNumberOfWays(face, noOfDice - 1, sum - j);
        }

    }

}

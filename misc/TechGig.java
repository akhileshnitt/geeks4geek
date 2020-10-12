package misc;

import java.util.Scanner;

public class TechGig {

    public static void main(String[] args) {
       /* long ingredRe [] = { 2,5,6,3};
        long totaolQty [] = {20,40,90,50};
*/

      /*  int ingredRe [] = { 10};
        int totaolQty [] = {20};
*/


        Scanner in =  new Scanner(System.in).useDelimiter("\n");
        long length = in.nextLong();
        String ing = in.next();
        String qty = in.next();


        long ingredRe[] = new long[(int) length];
        long totaolQty[] = new long[(int) length];
        int i = 0;
        for (String s : ing.split("\\s+")) {
            ingredRe[i] = Integer.valueOf(s);
            i++;
        }

        i = 0;
        for (String s : qty.split("\\s+")) {
            totaolQty[i] = Integer.valueOf(s);
            i++;
        }


        powerfull(ingredRe.length, ingredRe, totaolQty);


    }

    private static void powerfull(long length, long[] ingredRe, long[] totaolQty) {
        int i;
        long maxG[] = new long[(int) length];


        long max = Integer.MAX_VALUE;
        for ( i = 0; i < ingredRe.length; i++) {
            if(ingredRe[i] == 0 )return;
            maxG[i] = (int)Math.floor(totaolQty[i] / ingredRe[i]);

            if (maxG[i] < max) {
                max = maxG[i];
            }
        }

        System.out.println(Math.abs(max));
    }



}

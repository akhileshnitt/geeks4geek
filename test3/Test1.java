package test3;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Test1 {



    public static void main(String[] args) {
        int number = 101;

        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.CEILING);

        double root = findSquareRoot(number,1,number);
        System.out.println(root);

        root = findSquareRootDecimal(number,root-1,root,df);
        System.out.println(df.format(root));


    }

    private static double findSquareRootDecimal(int number, double low, double high, DecimalFormat df) {

        if(low >= high){
            return high;
        }
        double mid = (low+high)/2;


        if(Double.valueOf(df.format(mid*mid)) == number) return mid;

        else if(mid*mid > number){
            return  findSquareRootDecimal(number,low,mid, df);
        }

        return  findSquareRootDecimal(number,mid,high, df);

    }

    private static double findSquareRoot(int number,int low, int high) {

        if(low >= high){
            return high;
        }

        int mid = (low+high)/2;

        if(mid*mid == number) return mid;

        else if(mid*mid > number){
            return  findSquareRoot(number,1,mid);
        }
        return  findSquareRoot(number,mid+1,high);
    }
}

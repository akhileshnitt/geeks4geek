package misc;

public class RotationRequired {

    public static void main(String[] args) {
        int a = 1919;
        int b = 0000;

        int rotationReq = findRotation(a,b);
        System.out.println(rotationReq);
    }

    private static int findRotation(int a, int b) {

        int count = 0;
        while(a>0){
            int rema = a%10;
            a = a/10;
            int remb = b%10;
            b = b/10;


            if((rema ==9 && remb ==0 )||(rema ==0 && remb ==9 ))
                count += 1;
            else
            count += Math.abs(rema-remb);
   //         System.out.println(count);
        }

        return count;
    }
}

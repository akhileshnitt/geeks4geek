package mustodo.arrays.strings;

public class Atoi {

    public static void main(String[] args) {
        String s = "12a";
       // System.out.println(Integer.parseInt(s));

        int number = 0;
        try {
            number = convertToInteger(s);
            System.out.println(number);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static int convertToInteger(String s) throws Exception {
        int index =0;
        int sum=0;
        for (int i=s.length()-1;i>=0;i--){
            char c = s.charAt(i);
            if(!isNum(c)){
                throw new Exception("Number format ");
            }
            else{
                int n = Character.digit(c,10);
                double d  = n * Math.pow(10,index++);
                sum +=d;

            }
        }
        return sum;
    }

    private static boolean isNum(char c) {
       return Character.isDigit(c);
    }
}

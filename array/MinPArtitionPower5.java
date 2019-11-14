package array;

public class MinPArtitionPower5 {

    public static void main(String[] args) {
        String s = "1010000";

        int partiton = isPowerOf5(s);
      //  System.out.println(s);

        System.out.println(partiton);

    }



    private static int isPowerOf5(String s) {

        if(s.length() <=2){
            return -1;
        }
        int number = Integer.parseInt(s,2);

        if(isPowerFive(number)){
            return 0;
        }

        int count=-1;
        boolean isCorrect = true;
        for(int i=0;i<s.length();i++){
            String sub = s.substring(0,i+1);
            if(isPowerFive(Integer.parseInt(sub,2))){
                count++;
              //  System.out.println(sub);
                //check remaining string

                for(int j=i+1;j<s.length();j=j+sub.length()){
                    String rm = s.substring(j,j+sub.length());
                 //   System.out.println(rm);
                    if(!isPowerFive(Integer.parseInt(rm,2))){

                        isCorrect = false;
                        break;
                    }else{
                        count++;
                    }

                }

                if(!isCorrect){
                    return -1;
                }

            }
        }

        if(isCorrect){
            return count;
        }

        return -1;
    }

    private static boolean isPowerFive(int number) {

        int p = 5;
        for(int i=0;i<Math.sqrt(number);i++){
            if(number ==p){
                return true;
            }
            p = p*5;
        }
        return false;
    }
}

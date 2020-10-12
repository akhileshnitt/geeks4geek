package mustodo.arrays.hashing;

public class RepeatedChar {

    public static void main(String[] args) {
        String s = "geeksforgeeks";

        char initial = s.charAt(0);
        char repeated = 0;
        int repetIndex = Integer.MAX_VALUE;

        for(int i=1;i<s.length();i++){
            if(s.charAt(i) == initial){
                initial = s.charAt(i);
                repeated = s.charAt(i);
                if(i <repetIndex){
                    repetIndex = i;
                }
            }
            else{
                initial = s.charAt(i);
            }
        }

        System.out.println(repeated);
    }
}

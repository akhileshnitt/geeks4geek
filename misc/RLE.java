package misc;

public class RLE {

    public static void main(String[] args) {
        String s = "aaabbcaa";
        int count =1;
        char c = s.charAt(0);

        for(int i=1;i<s.length();i++){
            if(s.charAt(i) != c){
                System.out.print(c+""+count);
                count=1;
                c=s.charAt(i);
            }else{
                count++;
            }
        }

        System.out.print(c+""+count);
    }
}

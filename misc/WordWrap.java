package misc;

public class WordWrap {

    public static void main(String[] args) {
        String s = "This is Tesco Interview";

        for(int i=1;i<=s.length();i++) {
          //  int splitLength = 1;
            System.out.println();
            System.out.println("splitting on i :"+i);
            splitSentence(s, i);
        }
    }

    private static void splitSentence(String s, int splitLength) {

        String tokens [] = s.split(" ");

        StringBuilder sb = new StringBuilder();
        int count =0;
        for(int i=0;i<tokens.length;i++){

            count = count+tokens[i].length();
            if(count<=splitLength){
                sb.append(tokens[i]);
                sb.append(" ");

            }else{
                count = 0;
                count +=tokens[i].length();
                sb.append("\n");
                if(count>splitLength){
                    printDots(tokens[i],sb,splitLength);

                }
                else {

                    sb.append(tokens[i]);
                    sb.append(" ");
                }
            }
        }
        System.out.println(sb.toString());
    }

    private static void printDots(String token, StringBuilder sb, int splitLength) {
        if(token.length() <=splitLength){
            sb.append(token);
        }
        else{

            sb.append(token.substring(0,token.length()-splitLength));
            sb.append("-");
            sb.append("\n");
            sb.append(token.substring(token.length()-splitLength));
        }
    }
}

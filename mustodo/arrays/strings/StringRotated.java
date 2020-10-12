package mustodo.arrays.strings;

public class StringRotated {
    public static void main(String[] args) {
        String s1="amazon";
        String s2="azonam";

        String roatate = rotateBy2(s2);
        System.out.println(s1.equals(roatate));
    }


    private static String rotateBy2(String s2) {

        StringBuilder sb = new StringBuilder();
        sb.append(s2.substring(s2.length()-2));
        sb.append(s2.substring(0,s2.length()-2));



        return sb.toString();

    }
}

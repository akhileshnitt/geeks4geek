package misc;

import java.util.ArrayList;
import java.util.List;

public class NextBiggerNumber {

    public static void main(String[] args) {
       // String s = "218765";

       // String s = "534976";

       // String s = "1234";
       // String s = "4321";

        List<String> list = new ArrayList<>();
        list.add("218765");
        list.add("534976");
        list.add("1234");
        list.add("4321");
        list.add("5");
        list.add("000");

        //not working for this
        list.add("120");

        list.forEach(e->{
            System.out.print(e+" -> ");
            findNextGreaterElement(e);
            System.out.println();
        });

    }

    private static void findNextGreaterElement(String s) {
        if(s.length() ==1) {
            System.out.println("Greater element is not possible");
            return;
        }
        boolean possible = false;

        for(int i=s.length()-1;i>=1;i--){
            int lastChar = Integer.valueOf(s.charAt(i));
            int prevChar = Integer.valueOf(s.charAt(i-1));
            if(prevChar < lastChar){
                String left = s.substring(0,i-1);
                String right = s.substring(i-1);
            //    System.out.println(left);
            //    System.out.println(right);

                StringBuffer sb = new StringBuffer();
                sb.append(left);

                StringBuffer rightSB = new StringBuffer();
                rightSB.append(right);
                sb.append(rightSB.charAt(right.length()-1));
                rightSB.deleteCharAt(right.length()-1);

                sb.append(rightSB.charAt(0));
                rightSB.deleteCharAt(0);
                sb.append(rightSB.reverse());

                System.out.println(sb.toString());
                possible = true;

                break;
            }
        }
        if(!possible){
            System.out.println("Greater element is not possible");
        }
    }
}

package misc;

import java.util.ArrayList;
import java.util.List;

public class FirstOccurence {

    public static void main(String[] args) {
       /* String s = "xabcdey";
        String target = "ab*de";
*/


        String s = "juliasamanthaantjulia";
        String target = "ant";


        int index = findIndex(s, target);
        System.out.println(index);

    }

    private static int findIndex(String s, String target) {
        List<Integer> indexes = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == target.charAt(0)){
                indexes.add(i);
            }
        }


        for(Integer index: indexes){
            boolean found = false;
            for(int i=0;i<target.length();i++){
                if(index+i <s.length()){
                    if(target.charAt(i)!= '*' && s.charAt(index+i) !=  target.charAt(i)){
                        found = false;
                        break;
                    }
                    else{
                        found = true;
                    }
                }

            }
            if(found) return index;
        }


        return -1;

    }


}

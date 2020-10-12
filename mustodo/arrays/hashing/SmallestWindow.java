package mustodo.arrays.hashing;

public class SmallestWindow {
    public static void main(String[] args) {
      //  String s = "timetopractice";
       // String t = "toc";

        String s = "zoomlazapzo";
        String t = "oza";


        findSmallestString(s,t);
    }

    private static void findSmallestString(String s, String t) {
        if(t.length() >s.length()) System.out.println("Not Possible");

        String window ="";
        int minWindow = Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == t.charAt(0)){
                String sub  = findWindow(s,t,i);
                if(sub.length() != 0 && sub.length()<minWindow){
                    window = sub;
                    minWindow = sub.length();

                }
            }
        }
        System.out.println(window);
    }

    private static String findWindow(String s, String t, int index) {
        int initIndex = 1;
        int i=index+1;
        for(;i<s.length();i++){
            if(initIndex == t.length()) break;
            else if(s.charAt(i) == t.charAt(initIndex)){
                initIndex = initIndex+1;
            }

        }
        if(initIndex == t.length()) {
            return s.substring(index,i);
        }
        return "";
    }
}

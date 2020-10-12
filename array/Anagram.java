package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

public class Anagram {

    public static void main(String[] args) {
        String s1 = "geeksforgeeks";
        String s2 = "forgeeksgeeks";

        //boolean isAnagram = isAnagram(s1,s2);
        boolean isAnagram = isAnagram("cat","tac");
        System.out.println(isAnagram);


        reverseWord("i.like.this.program.very.much");

        longestPalidrome("aaaabbaa");
        removeDuplicate("geeksforgeek");


        removeDuplicate("acaaabbbacdddd");

        canObtain("amazon","zonama",3);

        canObtain("geeksforgeeks","geeksgeeksfor",2);

        mostFrequentWord("geeks for geeks");

        int arr[] = {4, 3, 6, 2, 1, 1};

        printMIssingandRepeating(arr,6);


    }

    private static void printMIssingandRepeating(int[] arr,int n) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=1;i<=n;i++){
            map.put(i,0);
        }

        for(int i=0;i<arr.length;i++){
            int count = map.get(arr[i]);
            map.put(arr[i],count+1);

        }

       Iterator itr= map.entrySet().iterator();
        while(itr.hasNext()){
            Map.Entry<Integer,Integer> entry = (Map.Entry<Integer, Integer>) itr.next();
            if(entry.getValue() ==0){
                System.out.println("MIssing :"+entry.getKey());
            }
            if(entry.getValue() >1){
                System.out.println("repeating :"+entry.getKey());
            }
        }
    }

    private static void mostFrequentWord(String s) {
        String [] tokens = s.split(" ");
        Map<String,Integer> map = new HashMap<>();

        for(String w : tokens){
            if(map.get(w) == null){
                map.put(w,1);

            }else{
                Integer count = map.get(w);
                map.put(w,count+1);

            }
        }


        //sort map based on value
        Set<Map.Entry<String, Integer>> set = map.entrySet();

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>();

        entryList.addAll(set);

        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (int)o2.getValue() - (int )o1.getValue();
            }
        });


        Map.Entry<String, Integer> fentry = entryList.get(0);



        for(int i=1;i<entryList.size();i++){
            if(fentry.getValue() ==  entryList.get(i).getValue()){
                fentry = entryList.get(i);
            }else{
                break;
            }
        }

        System.out.println(fentry.getKey());

    }

    static class wordCount {
        String word;
        String count;

        public wordCount(String word, String count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            wordCount wordCount = (wordCount) o;
            return word.equals(wordCount.word);
        }

        @Override
        public int hashCode() {
            return Objects.hash(word);
        }
    }
    private static void canObtain(String s1, String s2, int position) {

        int k=0;
        boolean isObt = true;
        for(int i=position;i<s1.length();i++){
            if(s1.charAt(i) != s2.charAt(k++)){
                isObt = false;
                break;
            }
        }

        for(int i=0;i<position;i++){
            if(s1.charAt(i) != s2.charAt(k++)){
                isObt = false;
                break;
            }
        }

        System.out.println(isObt);
    }

    private static void removeDuplicate(String s) {

        Stack<Character> st = new Stack<>();
        char c = s.charAt(0);
        st.push(c);

        for(int i=1;i<s.length();i++){

            if(c != s.charAt(i)){
                st.push(s.charAt(i));
                c= s.charAt(i);
            }
            else if (c== s.charAt(i)){
             //   st.push(s.charAt(i));
                st.pop();
             //   st.pop();
                if(!st.isEmpty()){
                    c= st.peek();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        System.out.println("remove duplicate");

        System.out.println(sb.reverse().toString());




    }

    private static void longestPalidrome(String s) {

        int longest = Integer.MIN_VALUE;
        String longestP = "";
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                String sub = s.substring(i,j+1);
         //       System.out.println(sub);
                if(isPalindrome(sub)){
                    if(sub.length() >longest){
                       // System.out.println(sub);
                        longest = sub.length();
                        longestP = sub;
                    }
                }
            }
        }

        System.out.println(longest+" --"+longestP);
    }

    private static boolean isPalindrome(String sub) {
        if(sub.length() ==0) return false;
        for(int i=0;i<sub.length()/2;i++){
            if(sub.charAt(i) != sub.charAt(sub.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    private static void reverseWord(String s) {
        String [] split = s.split("\\.");
        StringBuilder sb = new StringBuilder();

       /* for(String w: split){
            sb.append(new StringBuilder(w).reverse()).append(".");
        }*/

       for(int i=split.length-1;i>=0;i--){
           sb.append(split[i]).append(".");
       }

        System.out.println(sb.toString());
    }

    private static boolean isAnagram(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        Set<Character> set = new HashSet<>();
        for(char c : s1.toCharArray()){
            set.add(c);
        }

        boolean isAnagram = true;

        for(char c : s2.toCharArray()){
            if(set.add(c)){
                isAnagram = false;
            }
        }

        return isAnagram;

    }

}

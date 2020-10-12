package misc;

import java.util.HashMap;
import java.util.Map;

public class LongestCommmonPrefix {

    public static void main(String[] args) {
       // String words[] = {"geeksforgeek","geeks","geezer"};

        String words[] = {"apple", "ape", "april"};

        TrieNode root = new TrieNode();;
        for(int i=0;i<words.length;i++){
           buildTrie(words[i],root);
        }

        System.out.println(root);

        String s = lcp(root);
        System.out.println("LCP : "+s);
    }

    private static String lcp(TrieNode root) {

        StringBuffer sb = new StringBuffer();
        findLCP(root,sb);
        return sb.toString();
    }

    private static void findLCP(TrieNode root, StringBuffer s) {
        if(root.map.size()>1) return;
        Map.Entry<Character,TrieNode> node = root.map.entrySet().iterator().next();
        s.append(node.getKey());
        findLCP(node.getValue(),s);

    }

    private static void buildTrie(String word, TrieNode root) {

        for(int i=0;i<word.length();i++){
            if(root == null){
                root = new TrieNode();
            }
            if(root.map.get(word.charAt(i)) == null){
                TrieNode temp =  new TrieNode();
                root.map.put(word.charAt(i),temp);
                root = temp;
            }
            else{
                TrieNode temp =  root.map.get(word.charAt(i));
                root = temp;
            }
        }
        root.isEnd = true;

    }

    static class TrieNode{
        Map<Character,TrieNode> map;
        boolean isEnd ;

        public TrieNode() {
            this.map = new HashMap<>();
            this.isEnd = false;
        }
    }

}

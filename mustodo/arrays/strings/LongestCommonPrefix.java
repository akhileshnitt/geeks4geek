package mustodo.arrays.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        /*list.add("geeksforgeeks");
        list.add("geeks");
        list.add("geek");
        list.add("geezer");*/

        list.add("apple");
        list.add("ape");
        list.add("april");

        TrieNode root = null;

        for(String s : list){
            root = buildTrie(s,root);
        }

        StringBuilder sb  = new StringBuilder();
        StringBuilder s = lcp(root,sb);
        System.out.println(s.toString());
    }

    private static StringBuilder lcp(TrieNode root, StringBuilder sb) {
       if(root == null) return sb;

       if(root.map.size()>1) return sb;

       Iterator itr = root.map.entrySet().iterator();
       while(itr.hasNext()){
           Map.Entry<Character,TrieNode> entry = (Map.Entry<Character, TrieNode>) itr.next();
           sb.append(entry.getKey());
           lcp(entry.getValue(),sb);
       }
       return sb;
    }

    private static TrieNode buildTrie(String s, TrieNode root) {
        TrieNode node = root;
        if(node == null){
             node = root =  new TrieNode();
        }


        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(node.map.get(c) == null){
                TrieNode temp = new TrieNode();
                node.map.put(c,temp);
                node = temp;
            }
            else{
                node = node.map.get(c);
            }
        }
        node.isEOW = true;
        return root;
    }

    static class TrieNode{
        private Map<Character,TrieNode> map;
        private boolean isEOW ;

        public TrieNode() {
            this.map = new HashMap<>();
            isEOW = false;
        }
    }
}

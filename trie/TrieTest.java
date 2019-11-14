package trie;

import java.util.Map;

public class TrieTest {
    public static void main(String[] args) {

        String [] words = {"Dog","Doll","Dolls","Dick","Done","Dinner","Bat","Bats","Card","Cat","Apple","Ant","the", "a", "there",
                "answer", "any", "by",
                "bye", "their"};
        TrieNode root = new TrieNode();
        for(String word:words){
            root = buildTrie(word,root);
        }
   //     System.out.println(root);
        printSuggestion(root,"Ca");
    }

    private static void printSuggestion(TrieNode root, String prefix) {
        for(char c:prefix.toCharArray()){
            if(root.map.get(c) != null){
                root = root.map.get(c);
            }
        }
        traverseRec(root,prefix);
    }

    private static void traverseRec(TrieNode node, String prefix) {

        if(node.isEndOfWord()){
            System.out.println(prefix);

        }
        Map<Character,TrieNode> temp = node.map;
        for(Map.Entry<Character,TrieNode> entry :temp.entrySet()){
            StringBuilder sb = new StringBuilder(prefix);
            sb.append(entry.getKey());
            traverseRec(entry.getValue(),sb.toString());
        }

    }


    private static TrieNode buildTrie(String word, TrieNode root) {
        TrieNode current = root;
        for(char c:word.toCharArray()){

            TrieNode node = current.map.get(c);
            if(node == null){
                current.map.put(c,new TrieNode());
            }
            current = current.map.get(c);


        }
        current.endOfWord=true;

        return root;
    }
}

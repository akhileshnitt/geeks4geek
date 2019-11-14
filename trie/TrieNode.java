package trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    boolean endOfWord ;
    Map<Character,TrieNode> map;

    public TrieNode() {
        this.endOfWord = false;
        this.map = new HashMap<>();
    }

    public boolean isEndOfWord() {
        return endOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        this.endOfWord = endOfWord;
    }

    public Map<Character, TrieNode> getMap() {
        return map;
    }

    public void setMap(Map<Character, TrieNode> map) {
        this.map = map;
    }
}

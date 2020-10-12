package mustodo.arrays.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanCoding {

    public static void main(String[] args) {
        String input = "AAAAAABCCCCCCDDEEEEE";

        String encoded = huffmanEncoding(input);
        //System.out.println("encoded : "+encoded);
        System.out.println();

        System.out.println("OriginalString ----");
        System.out.println(input);
        System.out.println();
        System.out.println("Encoded String ----");
        System.out.println(encoded);


    }


    private static String huffmanEncoding(String input) {
        Map<Character,Integer> frequencyMap = new HashMap<>();
        for(int i=0;i<input.length();i++){
            if(frequencyMap.get(input.charAt(i)) == null){
                frequencyMap.put(input.charAt(i),1);
            }
            else{
                int freqenucy = frequencyMap.get(input.charAt(i));
                frequencyMap.put(input.charAt(i),freqenucy+1);
            }
        }
    //    System.out.println(frequencyMap);
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<HuffmanNode>();

        for(Map.Entry<Character,Integer> entry : frequencyMap.entrySet()){
            pq.add(new HuffmanNode(entry.getKey(),entry.getValue()));
        }

        // buile HuffmanTree
        HuffmanNode internalNode = null;
        while (pq.size()>1) {
            HuffmanNode first = pq.poll();
            HuffmanNode second = pq.poll();

            internalNode = new HuffmanNode('#', first.freq + second.freq);
            internalNode.left = first;
            internalNode.right = second;
            pq.add(internalNode);
        }


        Map<Character,String> codes = new HashMap<>();
        printCode(internalNode,"",codes);
      //  System.out.println(codes);



        String  encodedString = encode(input,codes);
        //  decode string
        System.out.println("decode string ----");
        decode(encodedString,internalNode,codes);

        return encodedString;
    }

    private static void decode(String encodedString, HuffmanNode internalNode, Map<Character, String> codes) {
        HuffmanNode root = internalNode;

        Map<String,Character> reverseCode = new HashMap<>();
        for (Map.Entry<Character,String> entry : codes.entrySet()){
            reverseCode.put(entry.getValue(),entry.getKey());
        }
        String temp="";
        for(int i=0;i<=encodedString.length();i++){

            if( internalNode.left == null && internalNode.right ==null){
                System.out.print(reverseCode.get(temp));
                temp ="";
                internalNode = root;
                i--;
            }
            else  if(i<encodedString.length() && encodedString.charAt(i) == '0'){
                temp+=encodedString.charAt(i);
                internalNode = internalNode.left;
            }
            else if(i<encodedString.length() && encodedString.charAt(i) == '1'){
                temp+=encodedString.charAt(i);
                internalNode = internalNode.right;
            }

        }


    }

    private static String encode(String input, Map<Character, String> codes) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<input.length();i++){
            sb.append(codes.get(input.charAt(i)));
        }
        return sb.toString();
    }

    private static void printCode(HuffmanNode internalNode, String s, Map<Character, String> codes) {
        if(internalNode == null) return;
        if(internalNode.left == null &&  internalNode.right == null){
         //   System.out.println(internalNode.c+ "-> "+s);
            codes.put(internalNode.c,s);
        }
        printCode(internalNode.left,s+"0", codes);
        printCode(internalNode.right,s+"1", codes);
    }

    static class HuffmanNode implements Comparable<HuffmanNode> {
        char c;
        int freq;
        HuffmanNode left;
        HuffmanNode right;

        public HuffmanNode(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }

        @Override
        public int compareTo(HuffmanNode o) {
            return (this.freq >o.freq)?1:-1;
        }
    }
}
